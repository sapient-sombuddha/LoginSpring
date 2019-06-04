package com.sapient.mutualfunds.LoginService.controller;

import com.sapient.mutualfunds.LoginService.models.Profile;
import com.sapient.mutualfunds.LoginService.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfilePostController {
    @Autowired
    ProfileService service;

    @GetMapping("/get")
    public List<Profile> get(){
        return service.getAll();
    }
}
