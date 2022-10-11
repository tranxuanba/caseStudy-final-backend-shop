package com.casestudy.controllers;

import com.casestudy.model.Bill;
import com.casestudy.model.CartItem;
//import com.casestudy.model.enums.Status;
import com.casestudy.model.enums.Status;
import com.casestudy.service.AppUserService;
import com.casestudy.service.BillService;
import com.casestudy.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin ("*")
@RequestMapping("/api")
public class ShoppingCartController {
    @Autowired
    private AppUserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BillService billService;

    @PostMapping("/cart/{uid}/{pid}/{qty}")
    public ResponseEntity<?> addItem(@PathVariable("qty") int qty,
                                     @PathVariable("pid") Long pid,
                                     @PathVariable("uid") Long uid) {
        LoginUser loginUser = userService.findById(uid).get();
        cartItemService.    addCartItem(qty,pid,loginUser);
        return new ResponseEntity<>(loginUser, HttpStatus.OK);
    }

    @GetMapping("cart/{uid}")
    public ResponseEntity<?> showCart(@PathVariable("uid") Long uid) {
        LoginUser loginUser = userService.findById(uid).get();
        List<CartItem> cartItems = cartItemService.getCartItemByUser(loginUser);
        return new ResponseEntity<>(cartItems,HttpStatus.OK);
    }

    @PutMapping("cart/{uid}/{pid}/{qty}")
    public ResponseEntity<?> updateCart(@PathVariable("qty") int qty,
                                        @PathVariable("pid") Long pid,
                                        @PathVariable("uid") Long uid) {
        cartItemService.updateQuantity(qty,pid,uid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("cart/{uid}/{pid}")
    public ResponseEntity<?> removeItem(@PathVariable("pid") Long pid,
                                        @PathVariable("uid") Long uid) {
        cartItemService.deleteByUserIdAndProductId(uid,pid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("cart/{uid}")
    public ResponseEntity<?> removeCart(@PathVariable("uid") Long uid) {
        cartItemService.removeByUserId(uid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/pay/{uid}")
    public ResponseEntity<?> pay(@RequestBody Bill bill, @PathVariable("uid")Long uid) {
        LoginUser loginUser = userService.findById(uid).get();
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        bill.setLoginUser(loginUser);
        bill.setCreatedAt(LocalDate.now());
        bill.setStatus(Status.PENDING);
////        simpleMailMessage.setTo(order.getEmail());
////        simpleMailMessage.setSubject("Mail Tri Ân Khách Hàng");
        List<CartItem> cartItems = cartItemService.getCartItemByUser(loginUser);
        boolean payCheck = billService.addReceipt(cartItems,bill);
//        simpleMailMessage.setText("Cảm ơn quý khách đã mua hàng tại shop");
//        simpleMailMessage.setText("Tên Khách Hàng : " +order.getFullName() +'\n'+
//                "Số điện thoại : "+order.getPhone() +'\n'+
//                "Địa chỉ : " + order.getAddress()+'\n'+
//                "Tình trạng đơn hàng : "+order.getStatus().getStatus()+'\n'+
//                "Ngày đặt hàng : "+order.getCreatedAt()+
//                "Xin cảm ơn quý khách !!!");
        cartItemService.removeByUserId(uid);
//        mailSender.send(simpleMailMessage);
        return new ResponseEntity<>(payCheck,HttpStatus.OK);
    }
}
