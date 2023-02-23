package com.jeroenreijn.examples.view;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeroenreijn.examples.model.Presentation;
import org.springframework.web.servlet.view.AbstractTemplateView;

public class HtmlFlowView extends AbstractTemplateView {

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Stream<Presentation> presentations = ((List<Presentation>) model.get("presentations")).stream();
		String html = HtmlFlowIndexView.view.render(presentations);

		response.setContentLength(html.length());
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter writer = response.getWriter()) {
			writer.write(html);
			writer.flush();
		}
	}
}
