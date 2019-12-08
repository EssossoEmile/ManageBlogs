package com.adipster.controllers;

import com.adipster.entities.User;
import com.adipster.daoRespository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRespository userRespository;

    @GetMapping("/user")
    public List<User> index(){
        return userRespository.findAll();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userRespository.findOne(userId);
    }

    @PostMapping("/user")
    public User create(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String email = body.get("email");

        return userRespository.save(new User(name, email));

    }

    @PostMapping("/user/search")
    public List<User> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return userRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body){
        // Getting User
        User user = userRespository.findOne(Integer.parseInt(id));
        user.setName(body.get("name"));
        user.setEmail(body.get("email"));
        return userRespository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        userRespository.delete(userId);
        return true;
    }

}
