package com.jeroenreijn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
        SpringTemplateEngine thymeleafTemplateEngine = new SpringTemplateEngine();
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/thymeleaf/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding(ConfigurationConstants.DEFAULT_ENCODING);
        thymeleafTemplateEngine.setTemplateResolver(resolver);
        return thymeleafTemplateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver r = new ThymeleafViewResolver();
        r.setViewNames(new String[]{"*-thymeleaf"});
        r.setTemplateEngine(thymeleafTemplateEngine());
        r.setContentType(ConfigurationConstants.CONTENT_TYPE);
        return r;
    }

}
