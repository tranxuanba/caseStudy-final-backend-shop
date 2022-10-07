package com.casestudy.service.billDetail;

import com.casestudy.model.Bill;
import com.casestudy.model.BillDetail;
import com.casestudy.repository.BillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillDetailService implements IBillDetailService{
    @Autowired
    private BillDetailRepository billDetailRepository;

    @Override
    public Page<BillDetail> findAll(Pageable pageable) {
        return billDetailRepository.findAll(pageable);
    }

    @Override
    public Iterable<BillDetail> findAll() {
        return billDetailRepository.findAll();
    }

    @Override
    public Optional<BillDetail> findById(Long id) {
        return billDetailRepository.findById(id);
    }

    @Override
    public BillDetail save(BillDetail billDetail) {
        return billDetailRepository.save(billDetail);
    }

    @Override
    public void remove(Long id) {
        billDetailRepository.deleteById(id);
    }

    @Override
    public List<BillDetail> findALlByBill(Bill bill) {
        return billDetailRepository.findAllByBill(bill);
    }

    @Override
    public Double calculateMoneyByBillId(Long billId) {
        return billDetailRepository.calculateMoneyByBillId(billId);
    }
}
