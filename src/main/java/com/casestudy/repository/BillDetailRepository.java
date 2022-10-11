package com.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillDetailRepository extends JpaRepository<BillDetail,Long> {
    List<BillDetail> findAllByBill(Bill bill);

    @Query( value = "select sum(p.price*bill_detail.number) from bill_detail join product p on p.id = bill_detail.product_id where bill_detail.bill_id = ?;", nativeQuery = true)
    Double calculateMoneyByBillId(Long billId);
}
