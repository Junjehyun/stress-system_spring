package com.ptsol.stress_system.service;

import com.ptsol.stress_system.mapper.KaisyaMstMapper;
import com.ptsol.stress_system.model.KaisyaMst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * KaisyaMst 使わないから、サービスまで作っておいて、後で活用する。
 */

@Service
public class KaisyaMstService {
    private final KaisyaMstMapper kaisyaMstMapper;
    @Autowired
    public KaisyaMstService(KaisyaMstMapper kaisyaMstMapper) {
        this.kaisyaMstMapper = kaisyaMstMapper;
    }

    public List<KaisyaMstMapper> getAllKaisyaMst() {
        return kaisyaMstMapper.findAll();
    }

    public List<KaisyaMst> searchCompaniesByName(String name) {
        return kaisyaMstMapper.findByName(name);
    }
}
