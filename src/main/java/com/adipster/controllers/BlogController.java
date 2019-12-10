package com.adipster.controllers;

import com.adipster.entities.Blog;
import com.adipster.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    private IBlogService iBlogService;

    @Autowired
    public BlogController(IBlogService theIBlogService) {
        iBlogService = theIBlogService;
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> index(){
        return new ResponseEntity<List<Blog>> (iBlogService.findAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return iBlogService.findBlogById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Blog blog){
        String searchBlog = blog.getTitle();
        return iBlogService.findByTitleContainingOrContentContaining(searchBlog);
    }

    @PostMapping("/blog")
    @Transactional
    public Blog create(@RequestBody Blog blog){
        return iBlogService.saveBlog(blog);
    }

    @PutMapping("/blog/{id}")
    @Transactional
    public Blog update(@RequestBody Blog theBlog){
        Blog blog = iBlogService.findBlogById(theBlog.getId());
        System.out.println("The blog value"+ blog);
        if (blog == null) {
            throw new RuntimeException("The Blog to update doesn't exist");
        }
        return iBlogService.saveBlog(theBlog);
    }

    @DeleteMapping("/blog/{id}")
    @Transactional
    public int delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        Blog blog = iBlogService.findBlogById(blogId);
        if (blog == null) {
            throw new RuntimeException("The Blog you want to delete doesn't exist");
        }
        iBlogService.deleteBlogById(blogId);
        return blogId;
    }


}
