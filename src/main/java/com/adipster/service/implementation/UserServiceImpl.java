package com.adipster.service.implementation;

import com.adipster.dao.interfaces.IUserDao;
import com.adipster.dao.repository.UserDaoJpaImpl;
import com.adipster.entities.User;
import com.adipster.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    IUserDao iUserDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoJpaImpl") IUserDao theIUserDao) {
        iUserDao = theIUserDao;
    }

    @Override
    public List<User> findAllUsers() {
        return iUserDao.getAllUsers();
    }

    @Override
    public User findUserById(int theId) {
        return iUserDao.findUserById(theId);
    }

    @Override
    public User saveUser(User theUser) {
        return iUserDao.saveUser(theUser);
    }

    @Override
    public int deleteUserById(int theId) {
        iUserDao.deleteUserById(theId);
        return theId;
    }
}
