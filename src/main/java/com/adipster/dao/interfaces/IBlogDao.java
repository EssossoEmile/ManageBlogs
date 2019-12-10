package com.adipster.dao.interfaces;

import com.adipster.entities.Blog;

import java.util.List;

public interface IBlogDao {

    List<Blog> getAllBlogs();

    Blog findBlogById(int theId);

    List<Blog> findByTitleContainingOrContentContaining(String text);

    Blog saveBlog(Blog theBlog);

    void deleteBlogById(int theId);
}
