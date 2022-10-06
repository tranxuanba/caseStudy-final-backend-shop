package com.casestudy.repository;

import com.casestudy.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<UserRole,Long> {
}
