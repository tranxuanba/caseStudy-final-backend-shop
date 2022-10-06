package com.casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    T findById(Long id);

    T save(T t);

    void deleteById(Long id);
}
