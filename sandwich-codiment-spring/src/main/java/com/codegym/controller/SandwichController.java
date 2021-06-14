package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/save")
    public String save(ModelMap model, @RequestParam(value = "condiment", required = false) String[] condiment) {
        model.addAttribute("condiments", condiment);
        return "result";
    }
}