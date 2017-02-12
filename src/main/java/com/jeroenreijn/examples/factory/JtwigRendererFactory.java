package com.jeroenreijn.examples.factory;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.translate.spring.SpringTranslateExtension;
import org.jtwig.translate.spring.SpringTranslateExtensionConfiguration;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class JtwigRendererFactory {
    @Autowired
    private MessageSource messageSource;

    public JtwigRenderer jtwigRenderer () {
        return new JtwigRenderer(EnvironmentConfigurationBuilder.configuration()
                .extensions()
                    .add(new SpringTranslateExtension(SpringTranslateExtensionConfiguration.builder(messageSource).build()))
                    .and()
                .build());
    }
}
