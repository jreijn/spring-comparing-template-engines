package com.jeroenreijn.examples.factory;

import com.jeroenreijn.examples.model.Presentation;
import com.jeroenreijn.examples.view.PresentationsKotlin;
import org.springframework.web.servlet.view.AbstractTemplateView;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

public class KotlinHtmlViewFactory extends AbstractTemplateViewResolver {

    public KotlinHtmlViewFactory() {
        this.setViewClass(this.requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return KotlinHtmlViewFactory.KotlinHtmlView.class;
    }

    public static class KotlinHtmlView extends AbstractTemplateView {

        @Override
        protected void renderMergedTemplateModel(
                Map<String, Object> map,
                HttpServletRequest req,
                HttpServletResponse res) throws Exception
        {
            Collection<Presentation> presentations = (Collection<Presentation>) map.get("presentations");

            String html = PresentationsKotlin.Companion.presentationsTemplate(presentations);

            // Headers
            res.setContentLength(html.length());
            res.setContentType("text/html");
            // Send body
            PrintWriter writer = res.getWriter();
            writer.write(html);
            writer.flush();
        }
    }
}
