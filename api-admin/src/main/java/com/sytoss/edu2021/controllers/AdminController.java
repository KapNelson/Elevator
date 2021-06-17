package com.sytoss.edu2021.controllers;


import com.sytoss.edu2021.models.Building;
import com.sytoss.edu2021.models.User;
import com.sytoss.edu2021.repo.BuildingRepository;
import com.sytoss.edu2021.repo.CabinRepository;
import com.sytoss.edu2021.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    CabinRepository cabinRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin")
    @ResponseBody
    public Iterable<User> writeEngine() {

        return userRepository.findAll();
    }

}
