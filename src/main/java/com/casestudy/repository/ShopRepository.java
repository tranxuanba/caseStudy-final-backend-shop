package com.casestudy.repository;

import com.casestudy.model.LoginUser;
import com.casestudy.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop , Long> {
    Shop findAllByLoginUser(LoginUser loginUser);
}
