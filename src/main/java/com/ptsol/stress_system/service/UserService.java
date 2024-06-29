package com.ptsol.stress_system.service;

import com.ptsol.stress_system.model.User;
import com.ptsol.stress_system.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    public List<User> getAllUsersWithDetails() {
        return userMapper.findAllWithDetails();
    }

    public User findById(String userId) {
        return userMapper.findById(userId);
    }
}
