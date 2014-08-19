package com.jeroenreijn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import httl.web.springmvc.HttlViewResolver;

/**
 * Created by jreijn on 20/08/14.
 */
@Configuration
public class HttlConfiguration {

    @Bean
    public ViewResolver httlViewResolver() {
        HttlViewResolver viewResolver = new HttlViewResolver();
        viewResolver.setPrefix("/WEB-INF/httl/");
        viewResolver.setContentType(ConfigurationConstants.CONTENT_TYPE);
        viewResolver.setSuffix(".httl");
        viewResolver.setViewNames(new String[]{"*-httl"});
        return viewResolver;
    }
}
