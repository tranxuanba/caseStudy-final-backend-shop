package com.casestudy.controllers;

import com.casestudy.model.Product;
import com.casestudy.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    ServletContext application;

    @GetMapping
    public ResponseEntity<Iterable<Product>> displayAllProduct() {
        List<Product> productList = (List<Product>) productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
