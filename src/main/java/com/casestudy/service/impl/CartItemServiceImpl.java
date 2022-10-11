package com.casestudy.service.impl;


import com.casestudy.model.entity.CartItem;
import com.casestudy.model.entity.Product;
import com.casestudy.model.entity.User;
import com.casestudy.repository.CartItemRepository;
import com.casestudy.repository.ProductRepository;
import com.casestudy.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepository;



    @Override
    public List<CartItem> getCartItemByUser(User user) {
        return cartRepo.getCartItemByUser(user);
    }

    public void addCartItem(int quantity,Long productId,User user) {
        Product product = productRepository.findById(productId).get();
        CartItem item = cartRepo.findByUserAndProduct(user,product);
        if(item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new CartItem();
            item.setProduct(product);
            item.setUser(user);
            item.setQuantity(quantity);
        }
        cartRepo.save(item);
    }

    @Override
    public void removeByUserId(Long id) {
        cartRepo.removeByUserId(id);
    }

    @Override
    public void updateQuantity(int quantity, Long productId, Long userId) {
        cartRepo.updateQuantity(quantity,productId,userId);
    }

    @Override
    public void deleteByUserIdAndProductId(Long userId, Long productId) {
        cartRepo.deleteByUserIdAndProductId(userId,productId);
    }
}
