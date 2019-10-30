package com.jeroenreijn.examples.view;

import liqp.filters.Filter;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

import java.util.Locale;

public class LiqpViewResolver extends AbstractTemplateViewResolver {
	public LiqpViewResolver(MessageSource messageSource) {
		this.setViewClass(this.requiredViewClass());

		Filter.registerFilter(new Filter("i18n") {
			@Override
			public Object apply(Object value, Object... params) {
				return messageSource.getMessage(value.toString(), null, Locale.ENGLISH);
			}
		});
	}

	@Override
	protected Class<?> requiredViewClass() {
		return LiqpView.class;
	}
}
