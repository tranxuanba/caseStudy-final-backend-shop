package com.casestudy.controllers;

import com.casestudy.service.shop.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shops")
@CrossOrigin("*")
public class ShopController {
    @Autowired
    private IShopService shopService;
    @GetMapping
    public ResponseEntity<Iterable<Shop>> findAllShop(){
        List<Shop> shops = (List<Shop>) shopService.findAll();
        if (shops.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Shop> findShopById(@PathVariable Long id){
        Optional<Shop> shopOptional = shopService.findById(id);
        if (!shopOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shopOptional.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop){
        return new ResponseEntity<>(shopService.save(shop), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Long id, @RequestBody Shop shop){
        Optional<Shop> shopOptional = shopService.findById(id);
        if (!shopOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shop.setId(shopOptional.get().getId());
        return new ResponseEntity<>(shopService.save(shop), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable Long id){
        Optional<Shop> shopOptional = shopService.findById(id);
        if (!shopOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shopService.remove(id);
        return new ResponseEntity<>(shopOptional.get(), HttpStatus.NO_CONTENT);
    }
}
