package com.ptsol.stress_system.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KaisyaMstMapper {
    List<KaisyaMstMapper> findAll();
}
