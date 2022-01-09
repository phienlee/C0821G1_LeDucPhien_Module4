package com.codegym.blog.service;



import com.codegym.blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);
}
