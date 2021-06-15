package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random()*1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Add new product successfully");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Update information successfully");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(Model model, @PathVariable int id){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Deleted successfully");
        return "redirect:/products";
    }
}
