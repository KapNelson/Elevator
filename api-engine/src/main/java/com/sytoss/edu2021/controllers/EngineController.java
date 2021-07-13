package com.sytoss.edu2021.controllers;

import com.sytoss.edu2021.repo.dto.EngineBOM;
import com.sytoss.edu2021.services.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engine")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @GetMapping
    public EngineBOM create(){
        return engineService.create();
    }

}
