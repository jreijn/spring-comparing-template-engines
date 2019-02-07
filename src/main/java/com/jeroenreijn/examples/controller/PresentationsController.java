package com.jeroenreijn.examples.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

import com.jeroenreijn.examples.model.i18nLayout;
import com.jeroenreijn.examples.services.PresentationsService;

@Controller
@RequestMapping("/")
public class PresentationsController {

	@Autowired
	PresentationsService presentationsService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	LocaleResolver localeResolver;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(HttpServletRequest request, final ModelMap modelMap) {
		return showList(request, "jsp", modelMap);
	}

	@RequestMapping(value = "/{template}", method = RequestMethod.GET)
	public String showList(HttpServletRequest request, @PathVariable(value = "template") final String template,
			final ModelMap model) {
		model.addAttribute("presentations", presentationsService.findAll());
		model.addAttribute("i18n", new i18nLayout(request, messageSource, localeResolver));
		
		return "index-" + template;
	}
}