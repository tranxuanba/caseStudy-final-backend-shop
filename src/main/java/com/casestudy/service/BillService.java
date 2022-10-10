package com.casestudy.service;


import com.casestudy.model.Bill;
import com.casestudy.model.CartItem;

import java.util.List;

public interface BillService {
    void save(Bill bill);
    boolean addReceipt(List<CartItem> cart, Bill bill);
    Iterable<Bill> getAllBill();
}
