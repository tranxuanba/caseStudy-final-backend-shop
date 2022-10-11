package com.casestudy.service.shop;

import com.casestudy.model.User;
import com.casestudy.service.IService;

public interface IShopService extends IService {
    Shop findAllByLoginUser(User loginUser);
    Shop save(Shop shop);
}
