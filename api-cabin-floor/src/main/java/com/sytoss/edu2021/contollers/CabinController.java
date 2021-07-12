package com.sytoss.edu2021.contollers;


import com.sytoss.edu2021.repo.dto.CabinBOM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/cabin_floor/cabin")
public class CabinController {


    @GetMapping
    public ResponseEntity<CabinBOM> getCabin(@RequestParam String address, @RequestParam Integer number) {
        ResponseEntity<CabinBOM> responseEntity =
                new RestTemplate().getForEntity(
                        "http://localhost:6060/api/building/find/cabin?address="+address+"&number="+number, CabinBOM.class);
        return responseEntity;

    }

}