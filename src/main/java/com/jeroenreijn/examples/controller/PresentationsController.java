package com.jeroenreijn.examples.controller;

import com.jeroenreijn.examples.services.PresentationsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PresentationsController {

    @Autowired
    PresentationsService presentationsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(final ModelMap modelMap) {
        return showList("jsp", modelMap);
    }

    @RequestMapping(value = "{template}", method = RequestMethod.GET)
    public String showList(@PathVariable(value = "template") final String template,
                           final ModelMap model) {
        model.addAttribute("presentations", presentationsService.findAll());
        return "index-" + template;
    }

}