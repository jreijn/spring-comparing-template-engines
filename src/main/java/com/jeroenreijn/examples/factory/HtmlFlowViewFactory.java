package com.jeroenreijn.examples.factory;

import com.jeroenreijn.examples.model.Presentation;
import com.jeroenreijn.examples.view.IndexHtmlFlow;
import org.springframework.web.servlet.view.AbstractTemplateView;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class HtmlFlowViewFactory extends AbstractTemplateViewResolver {

    public HtmlFlowViewFactory() {
        this.setViewClass(this.requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return HtmlFlowView.class;
    }

    public static class HtmlFlowView extends AbstractTemplateView {
        @Override
        protected void renderMergedTemplateModel(
            Map<String, Object> map,
            HttpServletRequest req,
            HttpServletResponse res) throws Exception
        {
            String html = IndexHtmlFlow
                .view
                .render(map);
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
