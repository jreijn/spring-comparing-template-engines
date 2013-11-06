/*-------------------- Thymol - the flavour of Thymeleaf --------------------*

   Thymol version 0.1.2 Copyright 2012 James J. Benson.
   jjbenson .AT. users.sf.net

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" basis,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either expressed or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 *---------------------------------------------------------------------------*/

var thURL = "http://www.thymeleaf.org";
var thPrefix = "th";
var thProtocol = "file:///";
var thCache = new Object;

$(function() {
	thymol();
});

var thymol = function() {
	
	var urlParams = {};
	(function() {
		var e, a = /\+/g, r = /([^&=]+)=?([^&]*)/g, d = function(s) {
			return decodeURIComponent(s.replace(a, " "));
		}, f = function(s) {
			return new Param(d(s));
		}, q = window.location.search.substring(1);
		while (e = r.exec(q)) {
			urlParams[d(e[1])] = f(e[2]);
		}
	})();

	var debug = getThParam("thDebug",true,false);
	var root = getThParam("thRoot",false,true);
	var path = getThParam("thPath",false,true);

	$.ajaxSetup({
		async : false,
		isLocal : true
	});

	(function() {
		var htmlTag = $("html")[0];
		$(htmlTag.attributes).each(function() {
			if (thURL == this.value) {
				var nsspec = this.localName.split(":");
				if (nsspec.length > 0) {
					thPrefix = nsspec[nsspec.length - 1];
					return;
				}
			}
		});
	})();

	var thIncl = new ThObj("include");
	var thSubs = new ThObj("substituteby");
	var thIf = new ThObj("if");
	var thUnless = new ThObj("unless");
	var thSwitch = new ThObj("switch");
	var thCase = new ThObj("case");

	var thFragEscp = "[" + thPrefix + "\\:fragment='";
	var base = new ThNode(document, false, null, null, null, document.nodeName, "::", false, document);
	process(base);
	return;

	function process(base) {
		var n = base;
		while (n.thDoc) {
			getChildren(n);
			if (n.firstChild && n.firstChild.thDoc && !n.visited) {
				n.visited = true;
				n = n.firstChild;
			}
			else {
				doReplace(n.isNode, n.element, n.thDoc);
				if (n.nextSibling && n.nextSibling.thDoc) {
					n = n.nextSibling;
				}
				else {
					if (n == base)
						break;
					else {
						n = n.parentDoc;
					}
				}
			}
		}
	}

	function getChildren(base) {
		var thIfSpecs = $(thIf.escp, base.thDoc);
		var thUnlessSpecs = $(thUnless.escp, base.thDoc);
		var thSwitchSpecs = $(thSwitch.escp, base.thDoc);
		var ths = $(thIfSpecs).add(thUnlessSpecs).add(thSwitchSpecs);
		ths.each(function() {
			var element = this;
			$(element.attributes).each(function() {
				var thAttr = this;
				if (thIf.name == thAttr.name || thUnless.name == thAttr.name || thSwitch.name == thAttr.name) {
					processConditional(element, base, thAttr);
				}
			});
		});
		var thInclSpecs = $(thIncl.escp, base.thDoc);
		var thSubsSpecs = $(thSubs.escp, base.thDoc);
		ths = $(thInclSpecs).add(thSubsSpecs);
		var count = 0;
		var last = null;
		ths.each(function() {
			var element = this;
			$(element.attributes).each(function() {
				var thAttr = this;
				if (thIncl.name == thAttr.name || thSubs.name == thAttr.name) {
					var child = processImport(element, base, thAttr);
					if( child != null ) {
						if (count == 0) {
							base.firstChild = child;
						}
						else {
							last.nextSibling = child;
						}
						last = child;
						count++;						
					}
				}
			});
		});
	}

	function processConditional(element, base, attr) {
		var args = attr.value.match(/[$\*#]{(!?.*)}/);
		var processed = false;
		if (args.length > 0) {
			var param = args[1];
			if (thSwitch.name == attr.name) {
				processed = processSwitch(element, base, attr, param);
			}
			else {
				var negate = false;
				if (args[1].charAt(0) == '!') {
					negate = true;
					param = args[1].substring(1);
				}
				if ((!negate && isTrue(param)) || (negate && !isTrue(param))) {
					if (thUnless.name == attr.name) { // true for "if" and
						// false for "unless"
						element.innerHTML = "";
					}
					processed = true;
				}
				else {
					if (thIf.name == attr.name) { // false for "if", true for
						// "unless"
						element.innerHTML = "";
					}
					processed = true;
				}

			}
		}
		if (!processed && debug) {
			window.alert("thymol.processConditional cannot process: " + attr.name + "=\"" + attr.value + "\"\n" + element.innerHTML);
		}
		element.removeAttribute(attr.name);
	}

	function processSwitch(element, base, attr, param) {
		var matched = false;
		var haveDefault = false;
		var thCaseSpecs = $(thCase.escp, element);
		thCaseSpecs.each(function() {
			var caseClause = this;
			var remove = true;
			$(caseClause.attributes).each(function() {
				var ccAttr = this;
				if (thCase.name == ccAttr.name) {
					if (!matched) {
						var s = urlParams[param];
						if (ccAttr.value == "*" || (s && (s.getStringValue() == ccAttr.value))) {
							matched = true;
							remove = false;
						}
					}
					caseClause.removeAttribute(ccAttr.name);
				}
			});
			if (remove) {
				caseClause.innerHTML = "";
			}
		});
		return matched;
	}

	function processImport(element, base, attr) {
		var importNode = null;
		var filePart = null;
		var fragmentPart = "::";
		if (attr.value.indexOf("::") < 0) {
			filePart = getFilePart(attr.value); 
		}
		else {
			var names = attr.value.split("::");
			filePart = getFilePart(names[0].trim());
			fragmentPart = substitute(names[1].trim());
		}
		var isNode = (thSubs.name == attr.localName);
		if (thCache[filePart] != null && thCache[filePart][fragmentPart] != null) {
			isNode = ((thSubs.name == attr.localName) || (fragmentPart == "::"));
			importNode = new ThNode(thCache[filePart][fragmentPart], false, base, null, null, filePart, fragmentPart, isNode, element);
		}
		else {
			var fileName = filePart + ".html";
			$.get(fileName, function(content, status) {
				if ("success" == status) {
					if (thCache[filePart] == null) {
						thCache[filePart] = new Object;
					}
					if (fragmentPart == "::") {
						var htmlContent = $("html", content)[0];
						thCache[filePart][fragmentPart] = htmlContent;
					}
					else {
						var fragSpec = thFragEscp + fragmentPart + "']";
						var fragArray = $(fragSpec, content);
						$(fragArray).each(function() {
							thCache[filePart][fragmentPart] = this;
						});
					}
					importNode = new ThNode(thCache[filePart][fragmentPart], false, base, null, null, filePart, fragmentPart, isNode, element);
				}
				else if (debug) {
					window.alert("file read failed: " + filePart + " fragment: " + fragmentPart);
				}
	    	}, "xml");
			if (importNode == null && debug) {
				window.alert("fragment import failed: " + filePart + " fragment: " + fragmentPart);
			}
		}
		element.removeAttribute(attr.name);		
		return importNode;
	}
	
	function getFilePart(part) {
		var result = substitute(part);
		if( result.charAt(0) != '.' ) {	// Initial period character indicates a relative path
			if( result.indexOf('/') >= 0 ) {	// If it doesn't start with a '.', and there are no path separators, it's also treated as relative
				result = thProtocol + root + path + result;													
			}
		}
		return result;
	}

	function doReplace(isNode, element, content) {
		if (isNode) {
			element.parentNode.replaceChild(content.cloneNode(true), element);
		}
		else {			
			try {
				element.innerHTML = content.innerHTML;
			}
			catch (err) { // Work-around for IE
				while (element.firstChild != null) {
					element.removeChild(element.firstChild);
				}
				for (i = 0; i < content.childNodes.length; i++) {
					element.appendChild(content.childNodes[i].cloneNode(true));
				}
			}			
		}
	}

	function ThNode(thDoc, visited, parentDoc, firstChild, nextSibling, fileName, fragName, isNode, element) {
		this.thDoc = thDoc;
		this.visited = visited;
		this.parentDoc = parentDoc;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
		this.fileName = fileName;
		this.fragName = fragName;
		this.isNode = isNode;
		this.element = element;
	}

	function ThObj(suffix) {
		this.name = thPrefix + ":" + suffix;
		this.escp = "[" + thPrefix + "\\:" + suffix + "]";
	}

	function Param(valueArg) {
		this.value = valueArg;
		this.getBooleanValue = function() {
			return !(this.value == "false" || this.value == "off" || this.value == "no");
		};
		this.getStringValue = function() {
			return this.value;
		};
		this.getNumericValue = function() {
			return Number(this.value);
		};
	}

	function isTrue(arg) {
		var p = urlParams[arg];
		if (p) {
			return p.getBooleanValue();
		}
		return false;
	}
	
	function substitute(argValue) {
		var result = argValue;
		var args = argValue.match(/[$\*#]{(!?.*)}/);
		if (args != null && args.length > 0) {
			var param = args[1];
			if(param) {
				var paramValue = urlParams[param];
				if (paramValue) {
					result = paramValue.value;
				}					
			}		
		}			
		return result;
	}

	function getThParam(paramName,isBoolean,isPath) {
		var localValue;
		if( isBoolean ) {
			localValue = false;
		}
		else {
			localValue = "";			
		}
		var theParam = urlParams[paramName];
		if (isBoolean && theParam) {
			localValue = theParam.getBooleanValue();
		}
		else {
			var paramValue;
			try {			
				paramValue = eval(paramName);
				if( !(typeof paramValue === "undefined") ) {
					if( paramValue != null ) {
						if ( isBoolean ) {
							localValue = (paramValue==true);
						}								
						else {
							localValue = paramValue;							
						}
					}
				}
			}
			catch (err) {
				if (err instanceof ReferenceError) {					
				}
				if (err instanceof EvalError) {					
				}
			}				
		}
		if( !isBoolean && isPath && localValue.length > 0 && localValue.charAt(localValue.length-1) != '/' ) {
			localValue = localValue + '/';
		}
		return localValue;
	}

};