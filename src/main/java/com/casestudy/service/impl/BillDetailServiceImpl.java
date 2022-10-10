package com.casestudy.service.impl;

import com.casestudy.model.BillDetail;
import com.casestudy.repository.BillDetailRepository;
import com.casestudy.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillDetailServiceImpl implements BillDetailService {
    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public void save(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }
}
