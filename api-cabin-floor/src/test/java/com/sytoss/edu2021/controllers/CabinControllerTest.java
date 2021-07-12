package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.ApiCabinFloorApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiCabinFloorApplication.class)
public class CabinControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void init()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void findCabinByAddressAndNumberTest() throws Exception
    {
        String address = "Peremoga Avenue 61";
        String number = String.valueOf(1);
        mockMvc.perform(get("/api/cabin_floor/cabin").param("address",address).param("number",number)).andDo(print())
                .andExpect(jsonPath("$.number")
                .value(1)).andExpect(status().isOk()).andReturn();
    }
    @Test
    public void setCurrentFloorTest() throws Exception
    {
        String address = "Peremoga Avenue 61";
        String number = String.valueOf(1);
        mockMvc.perform(get("/api/cabin_floor/cabin").param("address",address).param("number",number)).andReturn();
        mockMvc.perform(post("/api/cabin_floor/cabin/"+5)).andDo(print())
                .andExpect(jsonPath("$.currentFloor")
                        .value(5)).andExpect(status().isOk()).andReturn();
    }

}
