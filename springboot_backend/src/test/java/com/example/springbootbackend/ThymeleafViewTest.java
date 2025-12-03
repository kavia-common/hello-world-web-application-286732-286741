package com.example.springbootbackend;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ThymeleafViewTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET / should render HTML that includes nav labels and hero title")
    void indexRendersHtmlWithNavAndHero() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Spring Boot + Thymeleaf")))
                .andExpect(content().string(containsString("Home")))
                .andExpect(content().string(containsString("Hello")))
                .andExpect(content().string(containsString("API Docs")));
    }
}
