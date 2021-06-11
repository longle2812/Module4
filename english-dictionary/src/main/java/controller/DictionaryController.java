package controller;

import model.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String showForm(){
        return "index";
    }

    @PostMapping("/")
    public ModelAndView translate(@RequestParam(required = false, name = "eng") String eng){
        ModelAndView modelAndView = new ModelAndView("index");
        Dictionary dictionary = new Dictionary();
        if (dictionary.getDictionary().containsKey(eng)) {
            modelAndView.addObject("vnm", dictionary.getDictionary().get(eng));
        }
        else {
            modelAndView.addObject("vnm", "Khong tim thay ket qua");
        }
        return modelAndView;
    }
}
