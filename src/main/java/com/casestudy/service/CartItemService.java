package com.casestudy.service;

import com.casestudy.model.entity.CartItem;
import com.casestudy.model.entity.User;

import java.util.List;

public interface CartItemService {
    List<CartItem> getCartItemByUser(User user);

    void updateQuantity(int quantity, Long productId, Long userId);

    void deleteByUserIdAndProductId(Long userId, Long productId);

    void addCartItem(int quantity,Long productId,User user);

    void removeByUserId(Long id);
}
