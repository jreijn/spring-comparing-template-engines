package com.jeroenreijn.examples.view;

import com.jeroenreijn.examples.model.Presentation;
import htmlflow.DynamicHtml;
import htmlflow.HtmlView;
import org.springframework.web.servlet.support.RequestContext;
import org.xmlet.htmlapifaster.EnumMediaType;
import org.xmlet.htmlapifaster.EnumRelType;

import java.util.Map;

public class IndexHtmlFlow {
    public static final HtmlView<Map<String, Object>> view =
        DynamicHtml
            .view(IndexHtmlFlow::templatePresentations)
            .threadSafe();

    private static void templatePresentations(
        DynamicHtml<Map<String, Object>> view,
        Map<String, Object> map)
    {
        Iterable<Presentation> presentations = (Iterable<Presentation>) map.get("presentations");
        view
            .html()
                .head()
                    .meta().attrCharset("utf-8").__()
                    .meta().attrName("viewport").attrContent("width=device-width, initial-scale=1.0").__()
                    .meta()
                        .addAttr("http-equiv", "X-UA-Compatible")
                        .attrContent("IE=Edge")
                    .__()
                    .title().text("JFall 2013 Presentations").__()
                    .link()
                        .attrRel(EnumRelType.STYLESHEET)
                        .attrHref("/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css")
                        .attrMedia(EnumMediaType.SCREEN)
                    .__()
                .__()
                .body()
                    .div().attrClass("container")
                        .div().attrClass("page-header")
                            .h1().text("JFall 2013 Presentations").__()
                        .__() // div
                        .dynamic(container ->
                            presentations.forEach(presentation ->
                                container
                                    .div().attrClass("panel panel-default")
                                        .div().attrClass("panel-heading")
                                            .h3()
                                                .dynamic(h3 -> h3
                                                    .attrClass("panel-title")
                                                    .text(presentation.getTitle() + " - " + presentation.getSpeakerName())
                                                )
                                            .__()
                                        .__()
                                        .div()
                                            .dynamic(d -> d
                                                .attrClass("panel-body")
                                                .text(presentation.getSummary())
                                            )
                                        .__() // div
                                    .__() // div
                            ) // foreach
                        )
                    .__() // container
                .script().attrSrc("/webjars/jquery/3.1.1/jquery.min.js").__()
                .script().attrSrc("/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js").__()
                .__() // body
            .__(); // html
    }
}
