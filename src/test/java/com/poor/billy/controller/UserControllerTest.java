package com.poor.billy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poor.billy.dto.UserRegistrationDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
// (
//        SpringBootTest.WebEnvironment.MOCK,
//        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void registrationOk() throws Exception {

        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setName("Test");
        userRegistrationDTO.setLastName("Testov");
        userRegistrationDTO.setLogin("MyLogin");
        userRegistrationDTO.setPassword("qwerty123");
        userRegistrationDTO.setPasswordControl("qwerty123");

        mvc.perform(post("/api/user/registration")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userRegistrationDTO)))
                .andExpect(status().isOk());
    }
}