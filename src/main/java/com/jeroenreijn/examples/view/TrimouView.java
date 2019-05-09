package com.jeroenreijn.examples.view;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractTemplateView;
import org.trimou.Mustache;

public class TrimouView extends AbstractTemplateView {
	private Mustache mustache;

	protected TrimouView() {
	}

	public TrimouView(final Mustache mustache) {
		this.mustache = mustache;
	}

	public void setMustache(final Mustache mustache) {
		this.mustache = mustache;
	}

	@Override
	protected void renderMergedTemplateModel(final Map<String, Object> model, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		Objects.requireNonNull(mustache, "mustache must not be null");

		response.setCharacterEncoding("UTF-8");

		try (PrintWriter writer = response.getWriter()) {
			mustache.render(writer, model);
		}
	}
}
