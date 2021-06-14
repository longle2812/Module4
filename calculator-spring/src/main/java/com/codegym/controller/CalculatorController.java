package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(params = "+", method = RequestMethod.POST)
    public String addOperation(ModelMap model, @RequestParam("number1") double number1,@RequestParam("number2") double number2){
        double result = number1+ number2;
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("message", "Result Addition: " + result);
        return "index";
    }

    @RequestMapping(params = "/", method = RequestMethod.POST)
    public String divOperation(ModelMap model, @RequestParam("number1") double number1,@RequestParam("number2") double number2){
        double result = number1+ number2;
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("message", "Result Addition: " + result);
        return "index";
    }

    @RequestMapping(params = "-", method = RequestMethod.POST)
    public String subOperation(ModelMap model, @RequestParam("number1") double number1,@RequestParam("number2") double number2){
        double result = number1 - number2;
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("message", "Result Addition: " + result);
        return "index";
    }

    @RequestMapping(params = "x", method = RequestMethod.POST)
    public String mulOperatio(ModelMap model, @RequestParam("number1") double number1,@RequestParam("number2") double number2){
        double result = number1 * number2;
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("message", "Result Addition: " + result);
        return "index";
    }
}