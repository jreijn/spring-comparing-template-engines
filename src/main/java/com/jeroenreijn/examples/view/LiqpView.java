package com.jeroenreijn.examples.view;

import liqp.Template;
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

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String templateUrl = this.getUrl();
		File templateFile = ResourceUtils.getFile(templateUrl);
		if (templateFile.exists()) {
			// Liqp serializes the entire "model" to JSON Object and then to Map. This fails for custom and Spring classes
			model.remove("springMacroRequestContext");
			model.remove("org.springframework.validation.BindingResult.i18n");
			model.remove("i18n");

			// Just in case, we need it as in all other view resolvers
			model.put("contextPath", request.getContextPath());

			String rendered = Template.parse(templateFile).render(model);
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
