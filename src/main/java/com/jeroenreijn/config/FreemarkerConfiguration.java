package com.jeroenreijn.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class FreemarkerConfiguration {

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        Properties properties = new Properties();
        properties.setProperty("auto_import", "spring.ftl as spring");
        configurer.setTemplateLoaderPath("/WEB-INF/freemarker/");
        configurer.setDefaultEncoding(ConfigurationConstants.DEFAULT_ENCODING);
        configurer.setFreemarkerSettings(properties);
        return configurer;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setViewNames(new String[]{"*-freemarker"});
        resolver.setSuffix(".ftl");
        resolver.setContentType(ConfigurationConstants.CONTENT_TYPE);
        return resolver;
    }
}
