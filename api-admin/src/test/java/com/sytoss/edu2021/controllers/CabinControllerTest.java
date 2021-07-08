package com.sytoss.edu2021.controllers;

import com.google.gson.Gson;
import com.sytoss.edu2021.ApiAdminApplication;

import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.dto.BuildingBOM;
import com.sytoss.edu2021.repo.dto.BuildingDTO;
import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.services.convertor.BuildingConvertor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ApiAdminApplication.class)
class CabinControllerTest {

    private String address = "Peremoga Avenue 61";

    private int number = 2;

    private CabinBOM cabinBom;
    private BuildingBOM buildingBom;
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private BuildingRepository buildingRepository;
    private MockMvc mockMvc;
    @BeforeEach
    public void init()
    {
        BuildingDTO buildingDTO = buildingRepository.findBuildingByAddress(address);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        buildingBom = new BuildingBOM();
        new BuildingConvertor().fromDTO(buildingDTO,buildingBom);
        cabinBom = new CabinBOM();
        cabinBom.setNumber(number);
    }
    @Test
    public void normalInsertResult() throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(cabinBom);
        mockMvc.perform(post("/api/building/"+buildingBom.getId()+"/cabin").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

}


