package com.ptsol.stress_system.service;

import com.ptsol.stress_system.mapper.TaisyoSoshikiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaisyoSoshikiService {
    private final TaisyoSoshikiMapper taisyoSoshikiMapper;

    @Autowired
    public TaisyoSoshikiService(TaisyoSoshikiMapper taisyoSoshikiMapper) {
        this.taisyoSoshikiMapper = taisyoSoshikiMapper;
    }
    public List<TaisyoSoshikiMapper> getAllTaisyoSoshiki() {
        return taisyoSoshikiMapper.findAll();
    }

}
