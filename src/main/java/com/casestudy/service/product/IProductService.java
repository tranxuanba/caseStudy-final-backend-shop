package com.casestudy.service.product;

import com.casestudy.model.Product;
import com.casestudy.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product> {
    Page<Product> getAllProductByShop(Shop shop, Pageable pageable);
    List<Product> findByProductName(String name);
    List<Product> showAllProduct();
}
