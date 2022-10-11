package com.casestudy.repository;

import com.casestudy.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
