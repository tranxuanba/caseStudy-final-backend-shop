package com.casestudy.controller;

import com.casestudy.model.Category;
import com.casestudy.model.LoginUser;
import com.casestudy.model.Product;
import com.casestudy.model.Shop;
import com.casestudy.service.AppUserService;
import com.casestudy.service.category.CategoryService;
import com.casestudy.service.category.ICategoryService;
import com.casestudy.service.product.IProductService;
import com.casestudy.service.shop.IShopService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.awt.print.Pageable;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private IShopService shopService;
    @Autowired
    ServletContext application;

    @GetMapping
    public ModelAndView getAll(@PageableDefault(size = 5) Pageable pageable) {
        Shop shop = this.shop();
        Page<Product> products = productService.getAllProductByShop(shop, pageable);
        ModelAndView modelAndView = new ModelAndView("shop/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @ModelAttribute("currentUser")
    private LoginUser user() {
        return appUserService.findByUserName(user().getUsername());
    }

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }
    @ModelAttribute("currentShop")
    private Shop shop() {
        LoginUser currentUser = this.user();
        Shop shop = shopService.findAllByLoginUser(currentUser);
        return shop;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("shop/product/create");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product) throws IOException {
//        uploadFile(product);
        product.setShop(this.shop());
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("shop/product/create", "products", new Product());
        modelAndView.addObject("mess", "Tao moi thanh cong product ten la " + product.getName());
        return modelAndView;
    }
}
