package com.casestudy.service.shop;

import com.casestudy.model.LoginUser;
import com.casestudy.model.Shop;
import com.casestudy.service.IService;

public interface IShopService extends IService {
    Shop findAllByLoginUser(LoginUser loginUser);
}
