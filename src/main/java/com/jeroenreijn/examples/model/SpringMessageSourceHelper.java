package com.jeroenreijn.examples.model;

import static org.trimou.handlebars.OptionsHashKeys.LOCALE;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.trimou.handlebars.Options;
import org.trimou.handlebars.i18n.LocaleAwareValueHelper;
import org.trimou.util.Arrays;
import org.trimou.util.ImmutableSet;
import org.trimou.util.Strings;

public class SpringMessageSourceHelper extends LocaleAwareValueHelper {
	private static final String DEFAULT_MESSAGE = "defaultMessage";
	private final MessageSource messageSource;

	public SpringMessageSourceHelper(final MessageSource messageSource) {
		this.messageSource = Objects.requireNonNull(messageSource, "messageSource must not be null");
	}

	@Override
	public void execute(final Options options) {
		final String msgCode = options.getParameters().get(0).toString();
		final String defaultMessage = getDefaultMessage(options.getHash());
		final Locale locale = getLocale(options);
		final Object[] msgArguments = getMessageArguments(options.getParameters());
		try {
			if (Strings.isEmpty(defaultMessage)) {
				append(options, messageSource.getMessage(msgCode, msgArguments, locale));
			} else {
				append(options, messageSource.getMessage(msgCode, msgArguments, defaultMessage, locale));
			}
		} catch (NoSuchMessageException e) {
			append(options, msgCode);
		}
	}

	@Override
	protected Set<String> getSupportedHashKeys() {
		return ImmutableSet.of(LOCALE, DEFAULT_MESSAGE);
	}

	private String getDefaultMessage(final Map<String, Object> hash) {
		final Object value = hash.get(DEFAULT_MESSAGE);
		return value == null ? null : value.toString();
	}

	private Object[] getMessageArguments(final List<Object> params) {
		if (params.size() > 1) {
			return params.subList(1, params.size()).toArray();
		}
		return Arrays.EMPTY_OBJECT_ARRAY;
	}
}
