package com.jeroenreijn.examples.view;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class KotlinxHtmlViewResolver extends AbstractTemplateViewResolver {
	public KotlinxHtmlViewResolver() {
		this.setViewClass(this.requiredViewClass());
	}

	@Override
	protected Class<?> requiredViewClass() {
		return KotlinxHtmlView.class;
	}
}
