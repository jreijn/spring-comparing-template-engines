package com.jeroenreijn.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
public class VelocityConfiguration {

    @Bean
    public VelocityConfigurer velocityConfigurer() {
        VelocityConfigurer configurer = new VelocityConfigurer();
        Properties properties = new Properties();
        properties.setProperty("velocimacro.library", "includes.vm");
        configurer.setVelocityProperties(properties);
        configurer.setResourceLoaderPath("/WEB-INF/velocity/");
        return configurer;
    }

    @Bean
    public VelocityViewResolver velocityViewResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setViewNames(new String[]{"*-velocity"});
        resolver.setSuffix(".vm");
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setContentType(ConfigurationConstants.CONTENT_TYPE);
        return resolver;
    }
}
