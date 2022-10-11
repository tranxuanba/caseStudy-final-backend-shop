package com.casestudy.controller;

import com.casestudy.model.entity.Order;
import com.casestudy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    private ResponseEntity<?> showAllOrders(){
        Iterable<Order> orders = orderService.getAllOrders();
        if (orders != null){
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Không có order nào", HttpStatus.OK);
        }
    }
}
