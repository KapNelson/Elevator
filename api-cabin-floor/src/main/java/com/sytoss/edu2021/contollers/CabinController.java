package com.sytoss.edu2021.contollers;


import com.sytoss.edu2021.repo.dto.CabinBOM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/cabin_floor/cabin")
public class CabinController {


    @GetMapping
    public ResponseEntity<CabinBOM> getCabin(@RequestParam String address, @RequestParam Integer number) {
        ResponseEntity<CabinBOM> responseEntity =
                new RestTemplate().getForEntity(
                        "http://localhost:6060/api/building/find/cabin?address={address}&number={number}", CabinBOM.class, address, number);
        return responseEntity;
    }

}