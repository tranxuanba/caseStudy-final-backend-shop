package com.casestudy.service.comment;

import com.casestudy.model.User;
import com.casestudy.model.Product;
import com.casestudy.model.Review;
import com.casestudy.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Review> findAll() {
        return null;
    }

    @Override
    public Optional<Review> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Review save(Review userComment) {
        return commentRepository.save(userComment);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Review> findUserCommentByProduct(Product product) {
        return commentRepository.findUserCommentByProduct(product);
    }

    @Override
    public List<Review> findUserCommentByLoginUser(User loginUser) {
        return commentRepository.findUserCommentByLoginUser(loginUser);
    }
}
