package com.adipster.service.interfaces;

import com.adipster.entities.User;

import java.util.List;

public interface IUserService {

    public List<User> findAllUsers();

    public User findUserById(int theId);

    public User saveUser(User theUser);

    public int deleteUserById(int theId);
}
