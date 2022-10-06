package com.casestudy.service.billDetail;

import com.casestudy.model.Bill;
import com.casestudy.model.BillDetail;
import com.casestudy.service.IService;

import java.util.List;

public interface IBillDetailService extends IService<BillDetail> {
    List<BillDetail> findALlByBill(Bill bill);

    Double calculateMoneyByBillId(Long billId);
}
