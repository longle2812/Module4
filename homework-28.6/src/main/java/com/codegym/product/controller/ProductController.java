package com.codegym.product.controller;

import com.codegym.product.model.Category;
import com.codegym.product.model.Product;
import com.codegym.product.service.category.ICategoryService;
import com.codegym.product.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Page<Category> categories(Pageable pageable){
        return categoryService.findAll(pageable);
    }

    @ModelAttribute("products")
    public Page<Product> products(Pageable pageable){
        return productService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showAllProduct(@RequestParam (name="q") Optional<String> search, @PageableDefault(size = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView();
        if (search.isPresent()){
            modelAndView =  new ModelAndView("/product/list","products",productService.findProductByNameContaining(pageable, search.get()));
        }
        else{
            modelAndView =  new ModelAndView("/product/list","products",products(pageable));
        }
        modelAndView.addObject("categories", categories(pageable));
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreateForm(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/product/create", "categories", categories(pageable));
        modelAndView.addObject("product", new Product());
        return modelAndView;

    }

    @PostMapping("create")
    public ModelAndView saveNewProduct(@Validated @ModelAttribute Product product, BindingResult bindingResult, Pageable pageable){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/product/create");
        }
        productService.save(product);
        return new ModelAndView("/product/list","products", products(pageable));
    }

}
