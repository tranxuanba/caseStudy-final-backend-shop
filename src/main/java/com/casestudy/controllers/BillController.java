package com.casestudy.controllers;

import com.casestudy.model.Bill;
import com.casestudy.service.BillService;
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
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/bills")
    private ResponseEntity<?> showAllBill(){
        Iterable<Bill> bills = billService.getAllBill();
        if (bills != null) {
            return new ResponseEntity<>(bills, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Empty",HttpStatus.OK);
        }
    }
}
