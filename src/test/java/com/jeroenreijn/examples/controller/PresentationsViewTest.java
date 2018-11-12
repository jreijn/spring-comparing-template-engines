package com.jeroenreijn.examples.controller;

import com.jeroenreijn.examples.factory.HtmlFlowViewFactory;
import com.jeroenreijn.examples.InMemoryPresentationsRepository;
import com.jeroenreijn.examples.PresentationsRepository;
import com.jeroenreijn.examples.model.Presentation;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;

public class PresentationsViewTest {

    private final Map<String, Object> model;
    private static final Pattern GREATER = Pattern.compile(">");

    public PresentationsViewTest() {
        PresentationsRepository repo = new InMemoryPresentationsRepository();
        Iterable<Presentation> presentations = repo.findAll();
        model = new HashMap<>();
        model.put("presentations", presentations);
    }

    @Test
    public void htmlFlow_presentations_test() throws Exception {
        AbstractTemplateView view = getViewFromResolver(HtmlFlowViewFactory.class);
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        view.render(model, request(view), response(mem));
        /*
         * Assert
         */
        String html = mem.toString().replaceAll("\\s", "").toLowerCase();
        Iterator<String> actual = GREATER.splitAsStream(html).iterator();
        GREATER
            .splitAsStream(readExpectedOutputResource())
            .forEach(expected -> assertEquals(expected, actual.next()));
    }

    private static AbstractTemplateView getViewFromResolver(Class resolver)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        Object hfResolver = resolver.getConstructor().newInstance();
        Method requiredViewClass = HtmlFlowViewFactory.class.getDeclaredMethod("requiredViewClass");
        requiredViewClass.setAccessible(true);
        Class<?> viewClass = (Class<?>) requiredViewClass.invoke(hfResolver);
        return (AbstractTemplateView) viewClass.getConstructor().newInstance();
    }

    private static HttpServletResponse response(ByteArrayOutputStream mem) {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(mem));
        MockHttpServletResponse resp = new MockHttpServletResponse(writer);
        return resp;
    }

    private static HttpServletRequest request(AbstractTemplateView view) {
        MockServletContext ctx = new MockServletContext();
        ctx.setContextPath("HtmlFlow");
        final MockHttpServletRequest req = new MockHttpServletRequest(ctx);

        GenericWebApplicationContext appCtx = new GenericWebApplicationContext(req.getServletContext());
        view.setApplicationContext(appCtx);
        req.setAttribute(RequestContext.WEB_APPLICATION_CONTEXT_ATTRIBUTE, appCtx);
        return req;
    }

    private String readExpectedOutputResource() throws IOException {
        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    PresentationsViewTest.class.getResourceAsStream("/ExpectedPresentations.html"))))
        {
            return in
                .lines()
                .collect(Collectors.joining())
                .replaceAll("\\s", "")
                .toLowerCase();
        }
    }
}
