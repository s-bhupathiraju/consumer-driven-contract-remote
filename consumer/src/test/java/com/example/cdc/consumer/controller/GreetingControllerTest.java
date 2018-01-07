package com.example.cdc.consumer.controller;

import com.example.cdc.consumer.AbstractTest;
import com.example.cdc.consumer.dto.GreetingDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext
@AutoConfigureStubRunner(workOffline = false, ids = "com.example.cdc:producer:+:stubs:8092", repositoryRoot="https://eis.jfrog.io/eis/libs-snapshot-local")
//@AutoConfigureStubRunner(workOffline = false, ids = "com.example.cdc:producer:+:stubs:8092", repositoryRoot="https://PROPRIETARY_REPO/libs-snapshot-local")
public class GreetingControllerTest extends AbstractTest{

    @Autowired MockMvc mockMvc;
    @Autowired GreetingController greetingController;

    @Test
    public void should_print_a_formatted_message_when_there_is_a_prefix() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.write(new GreetingDTO("Greetings ", "EBSCO")).getJson()))
                .andExpect(status().isOk())
                .andExpect(content().string("Greetings EBSCO"));
    }

}
