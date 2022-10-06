package com.casestudy.repository;

import com.casestudy.model.LoginUser;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<LoginUser, Long> {
    LoginUser findByUsername(String username);
}
