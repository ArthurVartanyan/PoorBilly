//package com.poor.billy.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.poor.billy.dto.IncomeDTO;
//import com.poor.billy.model.operation.IncomeType;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//// (
////        SpringBootTest.WebEnvironment.MOCK,
////        classes = Application.class)
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:test.properties")
//public class IncomeControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Test
//    void createIncomeOk() throws Exception {
//
//        IncomeDTO incomeDTO = new IncomeDTO();
//        incomeDTO.setSum(new BigDecimal(88800));
//        incomeDTO.setType(IncomeType.GIFT);
//        incomeDTO.setTransactionDate(new Date());
//
//        mvc.perform(post("/api/income/new")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(incomeDTO)))
//                .andExpect(status().isOk());
//    }
//}