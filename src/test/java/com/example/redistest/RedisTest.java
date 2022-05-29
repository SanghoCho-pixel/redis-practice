package com.example.redistest;

import com.example.redistest.controller.MemberController;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class RedisTest {

    @Autowired
    private MockMvc mockMvc;

    @Before("mock")
    public void before(){
        mockMvc = MockMvcBuilders.standaloneSetup(MemberController.class)
                .alwaysExpect(MockMvcResultMatchers.status().isOk())
                .build();
    }

    @RepeatedTest(500)
    void ApiCall500() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/redis/exist/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @RepeatedTest(500)
    void ApiCall500NonCache() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/redis/exist/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
