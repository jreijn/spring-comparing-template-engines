package com.jeroenreijn.examples.configuration;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer;
import org.jtwig.translate.spring.SpringTranslateExtension;
import org.jtwig.translate.spring.SpringTranslateExtensionConfiguration;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
@Import({ WebMvcConfig.class })
public class JtwigConfig implements JtwigViewResolverConfigurer {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private LocaleResolver localeResolver;

	@Override
	public void configure(JtwigViewResolver viewResolver) {
		viewResolver.setRenderer(
				new JtwigRenderer(
						EnvironmentConfigurationBuilder
								.configuration()
								.extensions().add(new SpringTranslateExtension(SpringTranslateExtensionConfiguration
								.builder(messageSource)
								.withLocaleResolver(localeResolver)
								.build())).and()
								.build()
				)
		);
		viewResolver.setViewNames("*-jtwig");
		viewResolver.setPrefix("/WEB-INF/jtwig/");
		viewResolver.setSuffix(".twig");
	}
}
