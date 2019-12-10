package com.adipster.service.implementation;

import com.adipster.dao.interfaces.IBlogDao;
import com.adipster.dao.repository.BlogDaoJpaImpl;
import com.adipster.entities.Blog;
import com.adipster.service.interfaces.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    IBlogDao iBlogDao;

    @Autowired
    public BlogServiceImpl(@Qualifier("blogDaoJpaImpl") IBlogDao theIBlogDao) {
        iBlogDao = theIBlogDao;
    }

    @Override
    public List<Blog> findAllBlogs() {
        return iBlogDao.getAllBlogs();
    }

    @Override
    public Blog findBlogById(int theId) {
        return iBlogDao.findBlogById(theId);
    }

    @Override
    public List<Blog> findByTitleContainingOrContentContaining(String text) {
        return iBlogDao.findByTitleContainingOrContentContaining(text);
    }

    @Override
    public Blog saveBlog(Blog theBlog) {
        return iBlogDao.saveBlog(theBlog);
    }

    @Override
    public int deleteBlogById(int theId) {
        iBlogDao.deleteBlogById(theId);
        return theId;
    }
}
