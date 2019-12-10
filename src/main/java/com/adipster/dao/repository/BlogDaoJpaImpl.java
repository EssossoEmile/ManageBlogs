package com.adipster.dao.repository;

import com.adipster.dao.interfaces.IBlogDao;
import com.adipster.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BlogDaoJpaImpl implements IBlogDao {

    private EntityManager entityManager;

    @Autowired
    public BlogDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Blog> getAllBlogs() {
        Query query = (Query) entityManager.createQuery("from Blog");
        List<Blog> blogs = query.getResultList();
        return blogs;
    }

    @Override
    public Blog findBlogById(int theId) {
        Blog blog = entityManager.find(Blog.class, theId);
        return blog;
    }

    @Override
    public List<Blog> findByTitleContainingOrContentContaining(String text) {
        Query query = (Query) entityManager.createQuery("select bl from Blog bl where match(bl.title, :blogTitle)", Blog.class);
        query.setParameter("blogTitle", text);
        List<Blog> blogs = query.getResultList();
        return blogs;
    }

    @Override
    @Transactional
    public Blog saveBlog(Blog theBlog) {
        Blog dbBlog = entityManager.merge(theBlog);
        theBlog.setId(dbBlog.getId());
        return theBlog;
    }

    @Override
    public void deleteBlogById(int theId) {
        Query query = (Query) entityManager.createQuery("delete from Blog where id=:blogId");
        query.setParameter("blogId", theId);
        query.executeUpdate();
    }
}
