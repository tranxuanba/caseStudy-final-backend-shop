package com.casestudy.service.comment;

import com.casestudy.model.User;
import com.casestudy.model.Product;
import com.casestudy.model.Review;
import com.casestudy.service.IService;

import java.util.List;

public interface ICommentService extends IService<Review> {
    List<Review> findUserCommentByProduct(Product product);
    List<Review> findUserCommentByLoginUser(User loginUser);
}
