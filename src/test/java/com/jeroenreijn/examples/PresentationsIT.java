package com.jeroenreijn.examples;

import com.google.common.collect.Lists;
import com.jeroenreijn.examples.model.Presentation;
import com.jeroenreijn.examples.services.PresentationsService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PresentationsIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PresentationsService presentationsService;

    @BeforeEach
    void setup() {
        setupPresentationService();
    }

    void setupPresentationService() {
        Presentation presentation = new Presentation();
        presentation.setId(1L);
        presentation.setSummary("Test Summary");
        presentation.setTitle("Test Title");
        presentation.setRoom("Test Room");
        presentation.setSpeakerName("Speaker Name");
        presentation.setStartTime(Date.from(Instant.now()));
        presentation.setEndTime(Date.from(Instant.now()));

        when(this.presentationsService.findAll()).thenReturn(Lists.newArrayList(presentation));
    }

    @Test
    void whenKotlinX_thenReturns200() throws Exception {
        mockMvc.perform(get("/kotlinx").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - kotlinx.html")))
                .andExpect(view().name("index-kotlinx"));
    }

    @Test
    void whenIckenham_thenReturns200() throws Exception {
        mockMvc.perform(get("/ickenham").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Ickenham")))
                .andExpect(view().name("index-ickenham"));
    }

    @Test
    void whenScalate_thenReturns200() throws Exception {
        mockMvc.perform(get("/scalate").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Scalate")))
                .andExpect(view().name("index-scalate"));
    }

    @Test
    void whenJade4j_thenReturns200() throws Exception {
        mockMvc.perform(get("/jade").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Jade4j")))
                .andExpect(view().name("index-jade"));
    }

    @Test
    void whenChunk_thenReturns200() throws Exception {
        mockMvc.perform(get("/chunk").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Chunk")))
                .andExpect(view().name("index-chunk"));
    }

    @Test
    void whenHandlebars_thenReturns200() throws Exception {
        mockMvc.perform(get("/handlebars").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Handlebars")))
                .andExpect(view().name("index-handlebars"));
    }

    @Test
    void whenMustache_thenReturns200() throws Exception {
        mockMvc.perform(get("/mustache").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Mustache")))
                .andExpect(view().name("index-mustache"));
    }

    @Test
    void whenHandleRythm_thenReturns200() throws Exception {
        mockMvc.perform(get("/rythm").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Rythm")))
                .andExpect(view().name("index-rythm"));
    }

    @Test
    void whenHandleHttl_thenReturns200() throws Exception {
        mockMvc.perform(get("/httl").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Httl")))
                .andExpect(view().name("index-httl"));
    }

    @Test
    void whenPebble_thenReturns200() throws Exception {
        mockMvc.perform(get("/pebble").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Pebble")))
                .andExpect(view().name("index-pebble"));
    }

    @Test
    void whenTrimou_thenReturns200() throws Exception {
        mockMvc.perform(get("/trimou").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Trimou")))
                .andExpect(view().name("index-trimou"));
    }

    @Test
    void whenRocker_thenReturns200() throws Exception {
        mockMvc.perform(get("/rocker").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Rocker")))
                .andExpect(view().name("index-rocker"));
    }

    @Test
    void whenThymeleaf_thenReturns200() throws Exception {
        mockMvc.perform(get("/thymeleaf").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("index-thymeleaf"))
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Thymeleaf")));
    }

    @Test
    void whenGroovy_thenReturns200() throws Exception {
        mockMvc.perform(get("/groovy").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("index-groovy"))
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Groovy")));
    }

    @Test
    void whenLiqp_thenReturns200() throws Exception {
        mockMvc.perform(get("/liqp").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("index-liqp"))
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Liqp")));
    }

    @Test
    void whenVelocity_thenReturns200() throws Exception {
        mockMvc.perform(get("/velocity").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("index-velocity"))
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Velocity")));
    }

    @Test
    void whenFreemarker_thenReturns200() throws Exception {
        mockMvc.perform(get("/freemarker").contentType("text/html"))
                .andExpect(status().isOk())
                .andExpect(view().name("index-freemarker"))
                .andExpect(content().string(Matchers.containsString("JFall 2013 Presentations - Freemarker")));
    }
}