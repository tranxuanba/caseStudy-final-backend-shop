package com.casestudy.service.impl;

import com.casestudy.model.entity.CartItem;
import com.casestudy.model.entity.Order;
import com.casestudy.model.entity.OrderDetail;
import com.casestudy.model.entity.Product;
import com.casestudy.repository.OrderDetailRepository;
import com.casestudy.repository.OrderRepository;
import com.casestudy.repository.ProductRepository;
import com.casestudy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public boolean addReceipt(List<CartItem> cart, Order order) {
        if(!cart.isEmpty()) {
            orderRepository.save(order);
            for (CartItem item:cart) {
                Product product = productRepository.findById(item.getProduct().getId()).get();
                orderDetailRepository.save(new OrderDetail(order,item.getProduct(),item.getQuantity()));
                product.setQuantity(product.getQuantity() - item.getQuantity());
            }
            return true;
        } else return false;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
