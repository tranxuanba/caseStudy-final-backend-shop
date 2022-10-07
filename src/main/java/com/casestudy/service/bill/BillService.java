package com.casestudy.service.bill;

import com.casestudy.model.Bill;
import com.casestudy.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService implements IBillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Iterable<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void remove(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<Bill> findBillNotPayByUserId(Long userId){
        return billRepository.findBillNotPayByUserId(userId);
    }
}
