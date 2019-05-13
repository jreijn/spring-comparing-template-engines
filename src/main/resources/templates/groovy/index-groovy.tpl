layout 'base.tpl',
  title: "${i18n.message("example.title")} - Groovy",

  mainBody: contents {

    presentations.each { presentation ->
	  div(class: 'card mb-3 shadow-sm rounded') {
	    div(class: 'card-header') {
	      h5(class: 'card-title') {
	        yield "${presentation.title} - ${presentation.speakerName}"
	      }
	    }

	    fragment "div(class: 'card-body', summary)", summary: presentation.summary
	  }
	}
  }
