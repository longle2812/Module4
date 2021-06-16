package com.codegym.controller;


import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/setting")
public class EmailController {
    private Email email = new Email();

    @GetMapping("")
    public String showSettingForm(Model model){
        model.addAttribute("email", email);
        model.addAttribute("languages",new ArrayList<>(Arrays.asList("English", "Vietnamese", "Japanese", "Chinese")));
        model.addAttribute("sizes", new ArrayList<>(Arrays.asList(5, 10, 15, 25, 50, 100)));
        return "index";
    }

    @PostMapping("")
    public String saveSetting(@ModelAttribute Email email, Model model){
        model.addAttribute("email", email);
        model.addAttribute("languages",new ArrayList<>(Arrays.asList("English", "Vietnamese", "Japanese", "Chinese")));
        model.addAttribute("sizes", new ArrayList<>(Arrays.asList(5, 10, 15, 25, 50, 100)));
        model.addAttribute("message","Added successful");
        return "index";
    }
}
