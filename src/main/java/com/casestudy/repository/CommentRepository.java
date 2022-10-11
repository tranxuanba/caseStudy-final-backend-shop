package com.casestudy.repository;

import com.casestudy.model.User;
import com.casestudy.model.Product;
import com.casestudy.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Review,Long> {
    List<Review> findUserCommentByProduct(Product product);
    List<Review> findUserCommentByLoginUser(User loginUser);
}
