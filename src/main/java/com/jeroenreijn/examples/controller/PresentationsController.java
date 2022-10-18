package com.jeroenreijn.examples.controller;

import com.jeroenreijn.examples.model.i18nLayout;
import com.jeroenreijn.examples.services.PresentationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class PresentationsController {

    @Autowired
    PresentationsService presentationsService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    LocaleResolver localeResolver;

    @GetMapping
    public String home(HttpServletRequest request, final ModelMap modelMap) {
        return showList(request, "jsp", modelMap);
    }

    @GetMapping(value = "/{template}")
    public String showList(HttpServletRequest request, @PathVariable(value = "template") final String template,
                           final ModelMap model) {
        model.addAttribute("presentations", presentationsService.findAll());
        model.addAttribute("i18n", new i18nLayout(request, messageSource, localeResolver));

        return "index-" + template;
    }
}