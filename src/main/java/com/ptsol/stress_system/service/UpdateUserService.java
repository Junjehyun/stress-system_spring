package com.ptsol.stress_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptsol.stress_system.mapper.UpdateUserMapper;
import com.ptsol.stress_system.model.User;

@Service
public class UpdateUserService {

    @Autowired
    private UpdateUserMapper updateUserMapper;

    public User getUserById(String userId) {
        return updateUserMapper.getUserById(userId);
    }
}
