package com.jeroenreijn.examples.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

@Slf4j
public class LiqpViewResolver extends AbstractTemplateViewResolver {
    public LiqpViewResolver() {
        setViewClass(requiredViewClass());
        log.info("initialized.........");
    }

    @Override
    protected Class<?> requiredViewClass() {
        return LiqpView.class;
    }
}
