package com.example.demo.info;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.application.name=testApp",
        "spring.application.version=2.0.0"
})
public class InfoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getInfoUnit() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("testApp"))
                .andExpect(jsonPath("$.version").value("2.0.0"));
    }

//    @Autowired
//    private TestRestTemplate template;
//
//    @Test
//    public void getInfoIntegration() throws Exception {
//        ResponseEntity<String> response = template.getForEntity("/", String.class);
//        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
//    }
}