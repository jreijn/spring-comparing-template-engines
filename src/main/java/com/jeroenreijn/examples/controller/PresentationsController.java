package com.jeroenreijn.examples.controller;

import com.jeroenreijn.examples.model.i18nLayout;
import com.jeroenreijn.examples.services.PresentationsService;
import com.jeroenreijn.examples.view.JStachioView;

import io.jstach.jstachio.JStachio;
import io.jstach.jstachio.context.ContextJStachio;
import io.jstach.jstachio.context.ContextNode;
import io.jstach.jstachio.output.ThresholdEncodedOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    // JStachio does not use a normal resolver but a message converter
    // because this is Spring Boot 2.0 we need a bunch of extra code
    // as JStachio targets 3 which requires jakarta and not javax
    @GetMapping(value = "/jstachio")
    public void showJStachio(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        i18nLayout i18n = new i18nLayout(request, messageSource, localeResolver);
        JStachioView view = new JStachioView(presentationsService.findAll(), i18n::message);
        try(ServletThresholdEncodedOutput output =  new ServletThresholdEncodedOutput(StandardCharsets.UTF_8, response)) {
            ContextNode context = ContextNode.of(request::getAttribute);
            ContextJStachio jstachio =  ContextJStachio.of(JStachio.of());   
            jstachio.write(view, context, output);
        }
    }

    @GetMapping(value = "/{template}")
    public String showList(HttpServletRequest request, @PathVariable(value = "template") final String template,
                           final ModelMap model) {
        model.addAttribute("presentations", presentationsService.findAll());
        model.addAttribute("i18n", new i18nLayout(request, messageSource, localeResolver));

        return "index-" + template;
    }

    static class ServletThresholdEncodedOutput extends ThresholdEncodedOutput.OutputStreamThresholdEncodedOutput {

        private final HttpServletResponse response;

        public ServletThresholdEncodedOutput(Charset charset, HttpServletResponse response) {
            super(charset, calculateLimit(response));
            this.response = response;
        }

        private static int calculateLimit(HttpServletResponse response) {
            // int limit = response.getBufferSize();
            // if (limit <= 0) {
            // return 1024 * 128;
            // }
            // return limit;
            // the buffer size must have been insanely low
            return 1024 * 32;
        }

        @Override
        protected OutputStream createConsumer(int size) throws IOException {
            if (size > -1) {
                response.setContentLength(size);
                // It is already all in memory so we do not need a buffer.
                response.setBufferSize(0);
            }
            response.setContentType("text/html; charset=UTF-8");
            return response.getOutputStream();
        }
    }

}