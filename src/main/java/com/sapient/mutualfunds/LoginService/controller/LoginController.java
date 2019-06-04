package com.sapient.mutualfunds.LoginService.controller;

import com.sapient.mutualfunds.LoginService.models.Profile;
import com.sapient.mutualfunds.LoginService.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Period;

@Controller
public class LoginController {
    @Autowired
    ProfileService service;

    @GetMapping("/login")
    public String loginPageGet(Model model){
        model.addAttribute("profile", new Profile());
        return "login";
    }

    @PostMapping("login")
    public String loginPagePost(Model model, @ModelAttribute Profile profile){
        if (service.isUserPresent(profile.getUsername(), profile.getPassword())){
            model.addAttribute("message", "error");
            return "login";
        }
        else {
            model.addAttribute("message", "error");
            model.addAttribute("error", "Either username or password is wrong.");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signUpPageGet(Model model){
        model.addAttribute("profile", new Profile());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUpPagePost(Model model, @ModelAttribute Profile profile){
        if (service.isUsernamePresent(profile.getUsername())){
            model.addAttribute("error", "Username already present");
            model.addAttribute("message", "error");
        }else {
            model.addAttribute("message", "success");
            service.createProfile(profile.getName(), profile.getUsername(), profile.getPassword());
        }
        return "signup";
    }


//    @PostMapping("")
}
