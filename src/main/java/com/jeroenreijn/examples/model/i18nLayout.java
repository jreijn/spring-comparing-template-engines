package com.jeroenreijn.examples.model;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template.Fragment;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;

public class i18nLayout implements Mustache.Lambda {
	private final HttpServletRequest request;
	private final MessageSource messageSource;
	private final LocaleResolver localeResolver;

	public i18nLayout(HttpServletRequest request, MessageSource messageSource, LocaleResolver localeResolver) {
		this.request = request;
		this.messageSource = messageSource;
		this.localeResolver = localeResolver;
	}

	public String message(String key) {
		return messageSource.getMessage(key, null, localeResolver.resolveLocale(request));
	}

	@Override
	public void execute(Fragment frag, Writer out) throws IOException {
		String key = frag.execute();
		String text = messageSource.getMessage(key, null, localeResolver.resolveLocale(request));

		out.write(text);
	}
}
