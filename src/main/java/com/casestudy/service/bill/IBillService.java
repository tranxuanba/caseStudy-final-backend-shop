package com.casestudy.service.bill;

import com.casestudy.service.IService;

import java.util.List;

public interface IBillService extends IService<Bill> {
    List<Bill> findBillNotPayByUserId(Long userId);
}
