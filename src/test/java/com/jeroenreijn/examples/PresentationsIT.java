package com.jeroenreijn.examples;

import com.google.common.collect.Lists;
import com.jeroenreijn.examples.model.Presentation;
import com.jeroenreijn.examples.services.PresentationsService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
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

}