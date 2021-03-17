package com.jeroenreijn.examples.view;

import com.jeroenreijn.examples.model.Presentation;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class KotlinxHtmlView extends AbstractTemplateView {

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Iterable<Presentation> presentations = (Iterable<Presentation>) model.get("presentations");
		String html = KotlinxHtmlIndexView.Companion.presentationsTemplate(presentations);

		response.setContentLength(html.length());
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter writer = response.getWriter()) {
			writer.write(html);
			writer.flush();
		}
	}
}
