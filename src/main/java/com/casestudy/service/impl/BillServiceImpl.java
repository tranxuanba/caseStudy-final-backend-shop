package com.casestudy.service.impl;

import com.casestudy.model.Bill;
import com.casestudy.model.BillDetail;
import com.casestudy.model.CartItem;
import com.casestudy.model.Product;
import com.casestudy.repository.BillDetailRepository;
import com.casestudy.repository.BillRepository;
import com.casestudy.repository.ProductRepository;
import com.casestudy.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class BillServiceImpl implements BillService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public boolean addReceipt(List<CartItem> cart, Bill bill) {
        if (!cart.isEmpty()){
            billRepository.save(bill);
            for (CartItem item:cart){
                Product product = productRepository.findById(item.getProduct().getId()).get();
                billDetailRepository.save(new BillDetail(bill,item.getProduct(), item.getQuantity()));
                product.setQuantity(product.getQuantity() - item.getQuantity());
            }
            return true;
        }else return false;
    }

    @Override
    public Iterable<Bill> getAllBill() {
        return billRepository.findAll();
    }
}
