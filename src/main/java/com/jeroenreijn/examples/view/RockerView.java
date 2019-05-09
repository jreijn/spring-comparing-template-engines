package com.jeroenreijn.examples.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractTemplateView;

import com.fizzed.rocker.Rocker;

public class RockerView extends AbstractTemplateView {

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String html = Rocker.template("index.rocker.html")
				.bind("presentations", model.get("presentations"))
				.bind("i18n", model.get("i18n"))
				.render()
				.toString();

		response.setContentLength(html.length());
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter writer = response.getWriter()) {
			writer.write(html);
			writer.flush();
		}
	}

}
