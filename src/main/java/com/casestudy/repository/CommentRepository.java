package com.casestudy.repository;

import com.casestudy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<UserComment,Long> {
    List<UserComment> findUserCommentByProduct(Product product);
    List<UserComment> findUserCommentByLoginUser(LoginUser loginUser);
}
