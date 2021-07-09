package com.sytoss.edu2021.controllers;


import com.google.gson.Gson;
import com.sytoss.edu2021.ApiAdminApplication;

import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiAdminApplication.class)
class BuildingControllerTest {

    private String address = "test";
    private int floorsAmount = 9;
    private BuildingDTO buildingDTO;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    @BeforeEach
    public void init()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        buildingDTO = new BuildingDTO(address,floorsAmount);
    }

    @Test
    public void normalInsertResultTest() throws Exception {

        Gson gson = new Gson();
        String json = gson.toJson(buildingDTO);
        mockMvc.perform(post("/api/building").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(jsonPath("$.address")
                .value(address)).andExpect(jsonPath("$.floorsAmount")
                .value(floorsAmount)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void normalSearchByAddressResultTest() throws Exception
    {
        mockMvc.perform(get("/api/building/find/address/"+address)).andDo(print())
                .andExpect(jsonPath("$.address")
                .value(address)).andExpect(jsonPath("$.floorsAmount")
                .value(floorsAmount)).andExpect(status().isOk()).andReturn();
    }

    @Test
    public void zeroFloorsTest() throws Exception {

        String address = "Prospect Mira dom Kefira3";
        int floorsAmount = 0;
        buildingDTO = new BuildingDTO(address,floorsAmount);
        Gson gson = new Gson();
        String json = gson.toJson(buildingDTO);
        String response =  mockMvc.perform(post("/api/building").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(status().is(409)).andReturn().getResponse().getContentAsString();
        Assert.assertEquals("data is not valid",response);
    }

    @Test
    public void duplicateAddressesInsertTest() throws Exception {
        buildingDTO = new BuildingDTO(address,floorsAmount);
        Gson gson = new Gson();
        String json = gson.toJson(buildingDTO);
        String buildingBomString = mockMvc.perform(get("/api/building/find/address/"+address)).andReturn().getResponse().getContentAsString();
        BuildingBOM buildingBom = gson.fromJson(buildingBomString, BuildingBOM.class);
        String response =  mockMvc.perform(post("/api/building").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(status().is(409)).andReturn().getResponse().getContentAsString();
        Assert.assertEquals("Building with this address already registered. BuildingId=" + buildingBom.getId(),response);
    }
}