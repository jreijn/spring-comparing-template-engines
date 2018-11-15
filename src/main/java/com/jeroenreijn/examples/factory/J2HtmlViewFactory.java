package com.jeroenreijn.examples.factory;

import com.jeroenreijn.examples.model.Presentation;
import org.springframework.web.servlet.view.AbstractTemplateView;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static j2html.TagCreator.*;
import j2html.attributes.Attribute;

public class J2HtmlViewFactory extends AbstractTemplateViewResolver {

    public J2HtmlViewFactory() {
        this.setViewClass(this.requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return J2HtmlViewFactory.J2HtmlView.class;
    }

    public static class J2HtmlView extends AbstractTemplateView {

        private String HEADER = "<!DOCTYPE html>";

        @Override
        protected void renderMergedTemplateModel(
                Map<String, Object> map,
                HttpServletRequest req,
                HttpServletResponse res) throws Exception
        {
            Collection<Presentation> presentations = (Collection<Presentation>) map.get("presentations");

            String html = render(presentations);

            // Headers
            res.setContentLength(html.length());
            res.setContentType("text/html");
            // Send body
            PrintWriter writer = res.getWriter();
            writer.write(html);
            writer.flush();
        }

        String render(Collection<Presentation> presentations){
            return HEADER + html(
                    head(
                            meta().withCharset("utf-8"),
                            meta().withName("viewport").withContent("width=device-width, initial-scale=1.0"),
                            meta().attr(new Attribute("http-equiv", "Content-Language")).withContent("IE=Edge"),
                            title("JFall 2013 Presentations - htmlApi"),
                            link().withRel("Stylesheet").withHref("/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css").attr(new Attribute("media", "screen"))
                    ),
                    body(
                            div(
                                    div(
                                            h1("JFall 2013 Presentations - J2Html")
                                    ).withClass("page-header"),
                                    each(presentations, (Presentation presentation) ->
                                            div(
                                                    div(
                                                            h3(presentation.getTitle() + " - " + presentation.getSpeakerName()).withClass("panel-title")
                                                    ).withClass("panel-heading"),
                                                    div(presentation.getSummary()).withClass("panel-body")
                                            ).withClass("panel panel-default")
                                    )
                            ).withClass("container"),
                            script().withSrc("/webjars/jquery/3.1.1/jquery.min.js"),
                            script().withSrc("/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js")
                    )
            ).renderFormatted();
        }
    }
}
