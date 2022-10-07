package com.casestudy.service.comment;

import com.casestudy.model.LoginUser;
import com.casestudy.model.Product;
import com.casestudy.model.UserComment;
import com.casestudy.service.IService;

import java.util.List;

public interface ICommentService extends IService<UserComment> {
    List<UserComment> findUserCommentByProduct(Product product);
    List<UserComment> findUserCommentByLoginUser(LoginUser loginUser);
}
