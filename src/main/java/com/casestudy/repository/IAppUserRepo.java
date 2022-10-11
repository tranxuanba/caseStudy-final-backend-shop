package com.casestudy.repository;

import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<LoginUser, Long> {
    LoginUser findByUsername(String username);

    LoginUser findUserById (Long id);
}
