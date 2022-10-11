package com.casestudy.repository;

import com.casestudy.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = "SELECT * FROM casestudy4.review ORDER BY review.id DESC", nativeQuery = true)
    List<Review> findAllCommentByIdDesc();

    @Query(value = "SELECT * FROM casestudy4.review WHERE review.product_id = :id ORDER BY review.id DESC", nativeQuery = true)
    List<Review> findCommentsByIdProduct(Long id);
}
