package com.jeroenreijn.examples.view;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class RockerViewResolver extends AbstractTemplateViewResolver {
	public RockerViewResolver() {
		this.setViewClass(this.requiredViewClass());
	}

	@Override
	protected Class<?> requiredViewClass() {
		return RockerView.class;
	}
}
