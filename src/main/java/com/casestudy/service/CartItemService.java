package com.casestudy.service;

import com.casestudy.model.CartItem;
import com.casestudy.model.LoginUser;

import java.util.List;

public interface CartItemService {
    List<CartItem> getCartItemByUser(LoginUser loginUser);

    void updateQuantity(int quantity, Long productId, Long userId);

    void deleteByUserIdAndProductId(Long userId, Long productId);

    void addCartItem(int quantity,Long productId,LoginUser loginUser);

    void removeByUserId(Long id);
}
