package com.jeroenreijn.examples.view;

import com.jeroenreijn.examples.model.i18nLayout;
import liqp.ParseSettings;
import liqp.TemplateContext;
import liqp.TemplateParser;
import liqp.filters.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Locale;
import java.util.Map;

public class LiqpView extends AbstractTemplateView {
	private static final Logger LOGGER = LoggerFactory.getLogger(LiqpView.class);

	public LiqpView() {
		/*
		TemplateParser.Builder builder = new TemplateParser.Builder();
		builder.build().getParseSettings().flavor.getFilters().mergeWith(Filters.of(new Filter("i18n") {
			@Override
			public Object apply(Object value, Object... params) {
				return messageSource.getMessage(value.toString(), null, Locale.ENGLISH);
			}
})         ); */
	}

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String templateUrl = this.getUrl();
		File templateFile = ResourceUtils.getFile(templateUrl);
		//TemplateParser parser = new TemplateParser.Builder()

		if (templateFile.exists()) {
			// Liqp serializes the entire "model" to JSON Object and then to Map. This fails for custom and Spring classes
			model.remove("springMacroRequestContext");
			model.remove("org.springframework.validation.BindingResult.i18n");

			// Just in case, we need it as in all other view resolvers
			model.put("contextPath", request.getContextPath());

			ParseSettings parseSettings = new ParseSettings.Builder()
					.with(ParseSettings.DEFAULT)
					.with(new Filter("i18n") {
						@Override
						public Object apply(Object value, TemplateContext context, Object... params) {
							i18nLayout i18n = (i18nLayout) context.getVariables().get("i18n");
							return (value == null ? "" : i18n.message(value.toString()));
						}
					})
					.build();

			TemplateParser builder = new TemplateParser.Builder()
					.withParseSettings(parseSettings)
					.build();

			String rendered = builder.parse(templateFile).render(model);
			response.getWriter().write(rendered);
		} else {
			LOGGER.error("Template not found: {}", templateUrl);
		}
	}

	@Override
	public boolean checkResource(Locale locale) throws Exception {
		return this.getUrl().endsWith(".liqp");
	}
}
