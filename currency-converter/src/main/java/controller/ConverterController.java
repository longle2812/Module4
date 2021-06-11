package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

@Controller
public class ConverterController {
    @GetMapping("/")
    public String displayForm() {
        return "index";
    }

    @PostMapping("/")
    public ModelAndView convert(@RequestParam(required = false, name = "usd") String usd, @RequestParam(required = false, name = "rate") String rate) {
        ModelAndView modelAndView = new ModelAndView("index");
        float vnd = Float.parseFloat(rate) * (Float.parseFloat(usd));
        modelAndView.addObject("vnd", vnd);
        modelAndView.addObject("usd", usd);
        modelAndView.addObject("rate", rate);
        return modelAndView;
    }
}
