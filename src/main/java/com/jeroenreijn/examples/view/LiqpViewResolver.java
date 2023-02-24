package com.jeroenreijn.examples.view;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class LiqpViewResolver extends AbstractTemplateViewResolver {

	public LiqpViewResolver() {
		this.setViewClass(this.requiredViewClass());
	}

	@Override
	protected Class<?> requiredViewClass() {
		return LiqpView.class;
	}
}
