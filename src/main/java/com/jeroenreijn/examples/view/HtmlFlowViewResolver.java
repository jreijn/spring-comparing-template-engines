package com.jeroenreijn.examples.view;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class HtmlFlowViewResolver extends AbstractTemplateViewResolver {
	public HtmlFlowViewResolver() {
		this.setViewClass(this.requiredViewClass());
	}

	@Override
	protected Class<?> requiredViewClass() {
		return HtmlFlowView.class;
	}
}
