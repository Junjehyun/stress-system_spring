package com.ptsol.stress_system.mapper;

import com.ptsol.stress_system.model.TaisyoSoshiki;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaisyoSoshikiMapper {
    List<TaisyoSoshikiMapper> findAll();

    List<TaisyoSoshiki> findByName(@Param("soshikiName") String soshikiName);
}
