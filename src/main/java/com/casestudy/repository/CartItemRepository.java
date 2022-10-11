package com.casestudy.repository;


import com.casestudy.model.CartItem;
import com.casestudy.model.LoginUser;
import com.casestudy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> getCartItemByUser(LoginUser loginUser);

    CartItem findByUserAndProduct(LoginUser loginUser, Product product);

    @Transactional
    @Modifying
    @Query(value = "UPDATE CartItem c SET c.quantity = ?1 WHERE c.product.id = ?2 AND c.loginUser.id = ?3")
    void updateQuantity(int quantity, Long productId, Long userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cart_item as c WHERE c.login_user_id = ?1 AND c.products_id= ?2",nativeQuery = true)
    void deleteByUserIdAndProductId(Long userId, Long productId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cart_item as c WHERE c.login_user_id =:id",nativeQuery = true)
    void removeByUserId(Long id);
}