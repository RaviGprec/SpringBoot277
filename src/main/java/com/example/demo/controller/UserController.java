package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RaviKumarBanda
 */
@RestController
@RequestMapping("/v1/api/")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        users = userService.getAllUsers();
        return users;
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody User user)
    {
        Integer savedUserId = userService.addUser(user);
        return "User is added to the database table with the id - " + savedUserId;
    }
}
