package com.ptsol.stress_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ptsol.stress_system.model.User;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpdateUserMapper {
    
    User getUserById(@Param("userId") String userId);
    
    //User updateUser(User user);
    void updateUser(User user);
}
