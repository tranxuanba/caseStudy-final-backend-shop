package com.casestudy.service.shop;

import com.casestudy.model.LoginUser;
import com.casestudy.model.Shop;
import com.casestudy.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements IShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Page findAll(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    @Override
    public Iterable findAll() {
        return shopRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return shopRepository.findById(id);
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public void remove(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public Shop findAllByLoginUser(LoginUser loginUser) {
        return shopRepository.findAllByLoginUser(loginUser);
    }
}
