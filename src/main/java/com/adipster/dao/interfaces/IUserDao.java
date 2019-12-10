package com.adipster.dao.interfaces;

import com.adipster.entities.User;

import java.util.List;

public interface IUserDao {

    List<User> getAllUsers();

    User findUserById(int theId);

    User saveUser(User theUser);

    void deleteUserById(int theId);
}
