package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RaviKumarBanda
 */
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers()
    {
        List<User> usersList = new ArrayList<>();
        userRepository.findAll().forEach(
                user -> {
                    usersList.add(user);
                }
        );
        return usersList;
    }

    @Override
    public Integer addUser(User user)
    {
        return userRepository.save(user).getId();
    }
}
