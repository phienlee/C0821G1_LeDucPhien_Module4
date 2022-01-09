package com.example.blog.controller;


import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HomeController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Blog>> showHomePage() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> showCategoryList() {
        List<Category> categoryList = categoryService.findAll();
        List<Category> categoryArrayList = new ArrayList<>();
        for(Category c :categoryList){
            Category categoryDto = new Category();

            categoryDto.setId(c.getId());
            categoryDto.setName(c.getName());

            categoryArrayList.add(c);
        }
        return new ResponseEntity<>(categoryArrayList, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> showBlogList(){
        List<Blog> blogList = blogService.findAll();
        List<Blog> blogArrayList = new ArrayList<>();
        for(Blog b : blogList){
            Blog blogDto = new Blog();
            blogDto.setId(b.getId());
            blogDto.setName(b.getName());
            blogDto.setContent(b.getContent());
            blogDto.setPostDate(b.getPostDate());
            blogArrayList.add(b);
        }
        return new ResponseEntity<>(blogArrayList, HttpStatus.OK);
    }

    @GetMapping("/blog-category/{id}")
    public ResponseEntity<List<Blog>> showBlogInCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Blog> blogList = category.getList();
        List<Blog> blogArrayList = new ArrayList<>();
        for (Blog blog : blogList){
            Blog blogDto = new Blog();
            blogDto.setId(blog.getId());
            blogDto.setName(blog.getName());
            blogDto.setContent(blog.getContent());
            blogDto.setPostDate(blog.getPostDate());
            blogArrayList.add(blog);
        }
        return new ResponseEntity<>(blogArrayList,HttpStatus.OK);
    }

    @GetMapping("/blog-detail/{id}")
    public ResponseEntity<Blog> showBlogDetail(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blog blog1 = new Blog();
        blog1.setId(blog.getId());
        blog1.setName(blog.getName());
        blog1.setPostDate(blog.getPostDate());
        blog1.setContent(blog.getContent());
        return new ResponseEntity<>(blog1,HttpStatus.OK);
    }
}
