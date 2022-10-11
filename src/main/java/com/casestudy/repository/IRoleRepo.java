package com.casestudy.repository;

import com.casestudy.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role,Long> {
}
