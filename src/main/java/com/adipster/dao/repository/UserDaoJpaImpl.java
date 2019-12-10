package com.adipster.dao.repository;

import com.adipster.dao.interfaces.IUserDao;
import com.adipster.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoJpaImpl implements IUserDao {

    private EntityManager entityManager;

    @Autowired
    public UserDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        Query query = (Query) entityManager.createQuery("from User");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User findUserById(int theId) {
        User user = entityManager.find(User.class, theId);
        return user;
    }

    @Override
    public User saveUser(User theUser) {
        User dbUser = entityManager.merge(theUser);
        theUser.setId(dbUser.getId());
        return theUser;
    }

    @Override
    public void deleteUserById(int theId) {
        Query query = (Query) entityManager.createQuery("delete from User where id=:userId");
        query.setParameter("userId", theId);
        query.executeUpdate();
    }
}
