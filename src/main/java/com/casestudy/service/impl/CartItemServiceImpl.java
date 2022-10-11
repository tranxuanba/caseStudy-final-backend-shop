package com.casestudy.service.impl;

import com.casestudy.model.CartItem;
import com.casestudy.model.Product;
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
    public List<CartItem>getCartItemByUser(LoginUser loginUser) {
        return cartRepo.getCartItemByUser(loginUser);
    }

    @Override
    public void updateQuantity(int quantity, Long productId, Long userId) {
        cartRepo.updateQuantity(quantity,productId,userId);
    }

    @Override
    public void deleteByUserIdAndProductId(Long userId, Long productId) {
        cartRepo.deleteByUserIdAndProductId(userId,productId);
    }

    @Override
    public void addCartItem(int quantity, Long productId, LoginUser loginUser) {
        Product product = productRepository.findById(productId).get();
        CartItem item = cartRepo.findByUserAndProduct(loginUser,product);
        if(item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new CartItem();
            item.setProduct(product);
            item.setLoginUser(loginUser);
            item.setQuantity(quantity);
        }
        cartRepo.save(item);
    }

    @Override
    public void removeByUserId(Long id) {
        cartRepo.removeByUserId(id);
    }

}
