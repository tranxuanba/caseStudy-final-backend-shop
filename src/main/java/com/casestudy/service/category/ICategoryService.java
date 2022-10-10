package com.casestudy.service.category;

import com.casestudy.model.Category;
import com.casestudy.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IService<Category> {
    Page<Category> findAllByName(String name, Pageable pageable);
}
