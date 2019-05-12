package com.jeroenreijn.examples.view;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.trimou.engine.locator.AbstractTemplateLocator;
import org.trimou.engine.priority.WithPriority;

public class TrimouSpringResourceTemplateLocator extends AbstractTemplateLocator implements ResourceLoaderAware {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrimouSpringResourceTemplateLocator.class);

	static final String DEFAULT_CHARSET = "UTF-8";
	public static final String DEFAULT_PREFIX = "classpath:/templates/";
	public static final String DEFAULT_SUFFIX = ".trimou";

	private String charset = DEFAULT_CHARSET;
	private String prefix = DEFAULT_PREFIX;
	private String suffix = DEFAULT_SUFFIX;

	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	public TrimouSpringResourceTemplateLocator() {
		super(WithPriority.DEFAULT_PRIORITY);
	}

	@Override
	public Reader locate(String name) {
		final String resourceLocation = prefix + name + suffix;
		try {
			if (charset.isEmpty()) {
				return new InputStreamReader(resourceLoader.getResource(resourceLocation).getInputStream());
			}

			return new InputStreamReader(resourceLoader.getResource(resourceLocation).getInputStream(), charset);
		} catch (UnsupportedEncodingException e) {
			LOGGER.warn("Charset not supported: {}", charset);
		} catch (IOException e) {
			LOGGER.error("Template not found: {}", resourceLocation);
		}
		return null;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(final String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(final String suffix) {
		this.suffix = suffix;
	}
}
