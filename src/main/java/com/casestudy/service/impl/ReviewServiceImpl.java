package com.casestudy.service.impl;

import com.casestudy.model.entity.Review;
import com.casestudy.repository.ReviewRepository;
import com.casestudy.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAllCommentByIdDesc() {
        return reviewRepository.findAllCommentByIdDesc();
    }

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> findCommentsByIdProduct(Long id) {
        return reviewRepository.findCommentsByIdProduct(id);
    }
}
