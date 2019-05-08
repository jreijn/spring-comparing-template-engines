package com.jeroenreijn.examples.view;

import java.util.Locale;

import org.trimou.Mustache;
import org.trimou.engine.MustacheEngine;
import org.trimou.engine.MustacheEngineBuilder;

import com.jeroenreijn.examples.model.SpringMessageSourceHelper;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

public class TrimouViewResolver extends AbstractTemplateViewResolver {
	private SpringResourceTemplateLocator loader = new SpringResourceTemplateLocator();
	private MustacheEngine engine;

	public TrimouViewResolver(MessageSource messageSource) {
		this.setViewClass(this.requiredViewClass());

		this.engine = MustacheEngineBuilder.newBuilder().addTemplateLocator(loader)
				.registerHelper("springMsg", new SpringMessageSourceHelper(messageSource)).build();
	}

	@Override
	protected Class<?> requiredViewClass() {
		return TrimouView.class;
	}

	@Override
	public void setPrefix(final String prefix) {
		super.setPrefix(prefix);
		loader.setPrefix(prefix);
	}

	@Override
	public void setSuffix(final String suffix) {
		super.setSuffix(suffix);
		loader.setSuffix(suffix);
	}

	@Override
	protected View loadView(final String viewName, final Locale locale) throws Exception {
		Mustache mustache = engine.getMustache(viewName);
		if (mustache != null) {
			TrimouView trimouView = (TrimouView) super.loadView(viewName, locale);
			trimouView.setMustache(mustache);

			return trimouView;
		}
		return null;
	}
}
