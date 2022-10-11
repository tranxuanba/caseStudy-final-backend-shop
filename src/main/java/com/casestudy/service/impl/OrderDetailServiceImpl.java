package com.casestudy.service.impl;

import com.casestudy.model.entity.OrderDetail;
import com.casestudy.repository.OrderDetailRepository;
import com.casestudy.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }
}
