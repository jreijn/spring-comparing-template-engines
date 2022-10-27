package com.jeroenreijn.examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JmhTest {

    final LaunchJMH jmh = new LaunchJMH();

    public JmhTest() {
        jmh.startupSpring();
    }
    static final InputStream stream = JmhTest.class.getClassLoader().getResourceAsStream("expected-output.html");
	static final String expectedBody = new BufferedReader(new InputStreamReader(stream)).lines().collect(joining(""));
    static final Pattern MARKUP = Pattern.compile("<");
    static final Pattern NEWLINE = Pattern.compile("\n");

    private static void assertTemplateOutput(String actual, String name) {
		Iterator<String> expected = MARKUP
			.splitAsStream(expectedBody.replace("JSP", name))
			.iterator();
		MARKUP
			.splitAsStream(removeNewlinesTrimAndJoint(actual))
			.forEach(act -> {
				String e = expected.next().trim().toLowerCase();
				String a = act
				    .trim()
				    .toLowerCase()
                    .replaceAll("/>", ">")  // Some views still use void elements with a trailing / (slash).
				    .replaceAll("'", "\""); // Some views use ' instead of "
				assertEquals(e, a);
			});
		assertFalse(expected.hasNext());
	}
    private static String removeNewlinesTrimAndJoint(String source) {
        return NEWLINE
			.splitAsStream(source)
			.map(String::trim)
			.collect(joining(""));
    }

    @Test
	public void should_return_view_content_for_Chunk() throws Exception {
        String html = jmh.benchmarkChunk();
        assertTemplateOutput(html, "chunk");
    }
    @Test
	public void should_return_view_content_for_Freemarker() throws Exception {
        String html = jmh.benchmarkFreemarker();
        assertTemplateOutput(html, "freemarker");
    }
    @Test
	public void should_return_view_content_for_Groovy() throws Exception {
        String html = jmh.benchmarkGroovy();
        assertTemplateOutput(html, "groovy");
    }
    @Test
	public void should_return_view_content_for_Handlebars() throws Exception {
        String html = jmh.benchmarkHandlebars();
        assertTemplateOutput(html, "handlebars");
    }
    @Test
	public void should_return_view_content_for_HtmlFlow() throws Exception {
        String html = jmh.benchmarkHtmlFlow();
        assertTemplateOutput(html, "htmlFlow");
    }
    @Test
	public void should_return_view_content_for_HtmlHttl() throws Exception {
        String html = jmh.benchmarkHttl();
        assertTemplateOutput(html, "httl");
    }
    @Test
	public void should_return_view_content_for_Ickeman() throws Exception {
        String html = jmh.benchmarkIckenham();
        assertTemplateOutput(html, "ickenham");
    }
    @Test
	public void should_return_view_content_for_Jade() throws Exception {
        String html = jmh.benchmarkJade();
        assertTemplateOutput(html, "jade4j");
    }
    @Test
	public void should_return_view_content_for_JSP() throws Exception {
        String html = jmh.benchmarkJsp();
        System.out.println(html);
    }
    @Test
	public void should_return_view_content_for_KotlinxHtml() throws Exception {
        String html = jmh.benchmarkKotlinxHtml();
        assertTemplateOutput(html, "kotlinx.html");
    }
    @Test
	public void should_return_view_content_for_Liqp() throws Exception {
        String html = jmh.benchmarkLiqp();
        assertTemplateOutput(html, "liqp");
    }
    @Test
	public void should_return_view_content_for_Mustache() throws Exception {
        String html = jmh.benchmarkMustache();
        assertTemplateOutput(html, "mustache");
    }
    @Test
	public void should_return_view_content_for_Pebble() throws Exception {
        String html = jmh.benchmarkPebble();
        assertTemplateOutput(html, "pebble");
    }
    @Test
	public void should_return_view_content_for_Rocker() throws Exception {
        String html = jmh.benchmarkRocker();
        assertTemplateOutput(html, "rocker");
    }
    @Test
	public void should_return_view_content_for_Rythm() throws Exception {
        String html = jmh.benchmarkRythm();
        assertTemplateOutput(html, "rythm");
    }
    @Test
	public void should_return_view_content_for_Scalate() throws Exception {
        String html = jmh.benchmarkScalate();
        assertTemplateOutput(html, "scalate");
    }
    @Test
	public void should_return_view_content_for_Thymeleaf() throws Exception {
        String html = jmh.benchmarkThymeleaf();
        assertTemplateOutput(html, "thymeleaf");
    }
    @Test
	public void should_return_view_content_for_Trimou() throws Exception {
        String html = jmh.benchmarkTrimou();
        assertTemplateOutput(html, "trimou");
    }
    @Test
	public void should_return_view_content_for_Velocity() throws Exception {
        String html = jmh.benchmarkVelocity();
        assertTemplateOutput(html, "velocity");
    }

}
