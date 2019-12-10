package com.adipster.controllers;

import com.adipster.entities.User;
import com.adipster.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private IUserService iUserService;

    @Autowired
    public UserController(IUserService theIUserService) {
        iUserService = theIUserService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> index(){
        return new ResponseEntity<List<User>> (iUserService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return iUserService.findUserById(userId);
    }

    @PostMapping("/user")
    @Transactional
    public User create(@RequestBody User user) {
        return iUserService.saveUser(user);
    }

    @PutMapping("/user/{id}")
    @Transactional
    public User update(@PathVariable String id, @RequestBody User theUser){
        User user = iUserService.findUserById(theUser.getId());
        if (user == null) {
            throw new RuntimeException("The User to update doesn't exist");
        }
        return iUserService.saveUser(theUser);
    }

    @DeleteMapping("/user/{id}")
    @Transactional
    public int delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        User user = iUserService.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("The User you want to delete doesn't exist");
        }
        iUserService.deleteUserById(userId);
        return userId;
    }

}
