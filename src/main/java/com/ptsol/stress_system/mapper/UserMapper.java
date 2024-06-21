package com.ptsol.stress_system.mapper;

import com.ptsol.stress_system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
}
