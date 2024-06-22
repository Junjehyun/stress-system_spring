package com.ptsol.stress_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ptsol.stress_system.model.KaisyaMst;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KaisyaMstMapper {
    List<KaisyaMstMapper> findAll();
    List<KaisyaMst> findByName(@Param("name") String name);
}
