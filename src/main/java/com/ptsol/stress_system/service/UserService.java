package com.ptsol.stress_system.service;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public List<User> getAllUsersWithDetails() {
        return userMapper.findAllWithDetails();
    }
}
