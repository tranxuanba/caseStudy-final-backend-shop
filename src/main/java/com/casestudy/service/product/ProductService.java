package com.casestudy.service.product;

import com.casestudy.model.Product;
import com.casestudy.model.Shop;
import com.casestudy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getAllProductByShop(Shop shop, Pageable pageable) {
        return productRepository.getAllByShop(shop, pageable);
    }

    @Override
    public List<Product> findByProductName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> showAllProduct() {
        return productRepository.showAllProduct();
    }
}
