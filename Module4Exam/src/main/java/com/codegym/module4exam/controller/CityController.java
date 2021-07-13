package com.codegym.module4exam.controller;

import com.codegym.module4exam.exception.CustomException;
import com.codegym.module4exam.model.City;
import com.codegym.module4exam.model.Country;
import com.codegym.module4exam.service.city.ICityService;
import com.codegym.module4exam.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("cities")
    public Iterable<City> cities(){
        return cityService.findAll();
    }

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }


    @GetMapping("list")
    public ModelAndView showCityList(){
        return new ModelAndView("city/list");
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<City> city = cityService.findbyId(id);
        if (city.isPresent()){
            return new ModelAndView("city/edit", "city", city.get());
        }
        return new ModelAndView("404-error");
    }
    @GetMapping("view/{id}")
    public ModelAndView showCityDetail(@PathVariable Long id){
        Optional<City> city = cityService.findbyId(id);
        if (city.isPresent()){
            return new ModelAndView("city/view", "city", city.get());
        }
        return new ModelAndView("404-error");
    }

    @PostMapping("edit/{id}")
    public ModelAndView editCity(@Validated @ModelAttribute City city, BindingResult bindingResult) throws CustomException {
            if (bindingResult.hasFieldErrors()){
                return new ModelAndView("city/edit");
            }
            cityService.save(city);
            return new ModelAndView("city/list");
    }

    @GetMapping("create")
    public ModelAndView showCreatForm(){
        return new ModelAndView("city/create", "city", new City());
    }

    @PostMapping("create")
    public ModelAndView createNewCity(@Validated @ModelAttribute City city, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("city/create");
        }
        cityService.save(city);
        return new ModelAndView("city/list", "cities", cityService.findAll());
    }

    @PostMapping("delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id){
        cityService.remove(id);
        return new ModelAndView("city/list", "cities", cityService.findAll());
    }

    @GetMapping("delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<City> city = cityService.findbyId(id);
        if (city.isPresent()){
            return new ModelAndView("city/delete", "city", city.get());
        }
        return new ModelAndView("404-error");
    }

    @ExceptionHandler(CustomException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/city/input-error");
    }
}
