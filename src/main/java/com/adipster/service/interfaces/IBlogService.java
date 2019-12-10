package com.adipster.service.interfaces;

import com.adipster.entities.Blog;

import java.util.List;

public interface IBlogService {

    public List<Blog> findAllBlogs();

    public Blog findBlogById(int theId);

    List<Blog> findByTitleContainingOrContentContaining(String text);

    public Blog saveBlog(Blog theBlog);

    public int deleteBlogById(int theId);
}
