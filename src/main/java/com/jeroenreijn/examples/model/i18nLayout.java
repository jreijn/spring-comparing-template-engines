package com.jeroenreijn.examples.model;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template.Fragment;

public class i18nLayout implements Mustache.Lambda {
	private HttpServletRequest request;
	private MessageSource messageSource;
	private LocaleResolver localeResolver;

	public i18nLayout(HttpServletRequest request, MessageSource messageSource, LocaleResolver localeResolver) {
		this.request = request;
		this.messageSource = messageSource;
		this.localeResolver = localeResolver;
	}

	public String message(String key) {
		String text = messageSource.getMessage(key, null, localeResolver.resolveLocale(request));

		return text;
	}

	@Override
	public void execute(Fragment frag, Writer out) throws IOException {
		String key = frag.execute();
		String text = messageSource.getMessage(key, null, localeResolver.resolveLocale(request));

		out.write(text);
	}
}