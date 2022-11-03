package com.jeroenreijn.examples;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Some code on this class has been sampled from https://stackoverflow.com/a/41499972
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Thread)
public class LaunchJMH {

    static ConfigurableApplicationContext context;
    static MockMvc mockMvc;

    @Setup(Level.Trial)
    public synchronized void startupSpring() {
        try {
            if (context == null) {
                context = SpringApplication.run(Launch.class);
                mockMvc = MockMvcBuilders
                        .webAppContextSetup((WebApplicationContext) context)
                        .build();
            }
        } catch (Exception e) {
            //Force JMH crash
            throw new RuntimeException(e);
        }
    }

    @TearDown(Level.Trial)
    public synchronized void shutdownSpring() {
        try {
            if (context != null) {
                SpringApplication.exit(context);
                context = null;
            }
        } catch (Exception e) {
            //Force JMH crash
            throw new RuntimeException(e);
        }
    }

    private String benchmarkTemplate(String template) {
        try {
            ResultActions res = mockMvc.perform(
                get(format("/%s", template))
                    .accept(MediaType.ALL_VALUE)
            );
            return res.andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            //Force JMH crash
            throw new RuntimeException(e);
        }
    }
    @Benchmark
    public String benchmarkChunk() {
        return benchmarkTemplate("chunk");
    }
    @Benchmark
    public String benchmarkFreemarker() {
        return benchmarkTemplate("freemarker");
    }
    @Benchmark
    public String benchmarkGroovy() {
        return benchmarkTemplate("groovy");
    }
    @Benchmark
    public String benchmarkHandlebars() {
        return benchmarkTemplate("handlebars");
    }
    @Benchmark
    public String benchmarkHtmlFlow() {
        return benchmarkTemplate("htmlFlow");
    }
    @Benchmark
    public String benchmarkHttl() {
        return benchmarkTemplate("httl");
    }
        @Benchmark
    public String benchmarkIckenham() {
        return benchmarkTemplate("ickenham");
    }
    @Benchmark
    public String benchmarkJade() {
        return benchmarkTemplate("jade");
    }
    // Biased results because JSP resolver is not being invoked with MockMVC
    // and it is always resolved with an empty view!!!!
    @Benchmark
    public String benchmarkJsp() {
        return benchmarkTemplate("jsp");
    }
    @Benchmark
    public String benchmarkKotlinxHtml() {
        return benchmarkTemplate("kotlinx");
    }
    @Benchmark
    public String benchmarkLiqp() {
        return benchmarkTemplate("liqp");
    }
    @Benchmark
    public String benchmarkMustache() {
        return benchmarkTemplate("mustache");
    }
    @Benchmark
    public String benchmarkPebble() {
        return benchmarkTemplate("pebble");
    }
    @Benchmark
    public String benchmarkRocker() {
        return benchmarkTemplate("rocker");
    }
    @Benchmark
    public String benchmarkRythm() {
        return benchmarkTemplate("rythm");
    }
    @Benchmark
    public String benchmarkScalate() {
        return benchmarkTemplate("scalate");
    }
    @Benchmark
    public String benchmarkThymeleaf() {
        return benchmarkTemplate("thymeleaf");
    }
    @Benchmark
    public String benchmarkTrimou() {
        return benchmarkTemplate("trimou");
    }
    @Benchmark
    public String benchmarkVelocity() {
        return benchmarkTemplate("velocity");
    }
}
