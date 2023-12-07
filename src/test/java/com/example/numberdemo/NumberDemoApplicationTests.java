package com.example.numberdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest
class NumberDemoApplicationTests {

    @Autowired
    ConversionController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void testBinaryToRoman() {
        try {
            MvcResult result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/convert/binary-to-roman/101")
            ).andReturn();
            assert result.getResponse().getStatus() == 200;
            assert result.getResponse().getContentAsString().equals("V");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDecimalToRoman() {
        try {
            MvcResult result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/convert/decimal-to-roman/42")
            ).andReturn();
            assert result.getResponse().getStatus() == 200;
            assert result.getResponse().getContentAsString().equals("XLII");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
