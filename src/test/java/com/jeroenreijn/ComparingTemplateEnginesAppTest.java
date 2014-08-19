package com.jeroenreijn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ComparingTemplateEnginesApp.class)
public class ComparingTemplateEnginesAppTest {

    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(applicationContext).build();
    }

    @Test
    public void benchmarkJsp() throws Exception {
        mockMvc.perform(get("/jsp")).andExpect(status().isOk());
    }

    @Test
    public void benchmarkFreemarker() throws Exception {
        mockMvc.perform(get("/freemarker")).andExpect(status().isOk());
    }

    @Test
    public void benchmarkVelocity() throws Exception {
        mockMvc.perform(get("/velocity")).andExpect(status().isOk());
    }

    @Test
    public void benchmarkThymeleaf() throws Exception {
        mockMvc.perform(get("/thymeleaf")).andExpect(status().isOk());
    }

}