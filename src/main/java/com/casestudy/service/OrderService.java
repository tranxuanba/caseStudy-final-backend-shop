package com.casestudy.service;


import com.casestudy.model.entity.CartItem;
import com.casestudy.model.entity.Order;

import java.util.List;


public interface OrderService {
    void save(Order order);
    boolean addReceipt(List<CartItem> cart, Order order);
    Iterable<Order> getAllOrders();
}
