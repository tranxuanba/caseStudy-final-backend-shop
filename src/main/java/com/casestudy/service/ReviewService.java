package com.casestudy.service;

import com.casestudy.model.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllCommentByIdDesc();
    void saveReview(Review review);
    List<Review> findCommentsByIdProduct(Long id);
}
