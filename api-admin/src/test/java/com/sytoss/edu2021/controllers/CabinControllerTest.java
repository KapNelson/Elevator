package com.sytoss.edu2021.controllers;

import com.google.gson.Gson;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CabinControllerTest {

    private String address = "fff";
    private int floorsAmount = 3;
    private int number = 5;

    private CabinDTO cabinDTO;
    private BuildingDTO buildingDTO;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    @BeforeEach
    public void init()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        buildingDTO = new BuildingDTO(address,floorsAmount);
        cabinDTO = new CabinDTO(number,buildingDTO);
    }
    @Test
    public void normalInsertResult() throws Exception {


        Gson gson = new Gson();
        String json = gson.toJson(cabinDTO);
        mockMvc.perform(post("{id}/cabin").param("id","23").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(jsonPath("$.number")
                .value(number)).andExpect(status().isOk()).andReturn();

    }

}