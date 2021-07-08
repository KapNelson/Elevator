package com.sytoss.edu2021.contollers;


import com.sytoss.edu2021.repo.dto.CabinBOM;
import com.sytoss.edu2021.services.CabinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cabin_floor/cabin")
public class CabinController {

    @Autowired
    private CabinService cabinService;

    @GetMapping
    public CabinBOM getCabin(@RequestParam String address, @RequestParam Integer number){
        CabinBOM cabinBOM = cabinService.getCabin(address,number);
        return cabinBOM;
    }


}