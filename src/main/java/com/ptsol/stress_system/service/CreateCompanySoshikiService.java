package com.ptsol.stress_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ptsol.stress_system.mapper.CreateCompanySoshikiMapper;
import com.ptsol.stress_system.model.User;

@Service
public class CreateCompanySoshikiService {

    private final CreateCompanySoshikiMapper createCompanySoshikiMapper;

    public CreateCompanySoshikiService(CreateCompanySoshikiMapper createCompanySoshikiMapper) 
    {
        this.createCompanySoshikiMapper = createCompanySoshikiMapper;
    };

    /**
     * 会社名を取得するメソッド
     * このメソッドはCreateCompanySoshikiMapperを呼び出して、
     * KAISYA_MSTテーブルから会社名を取得する
     * 
     * @return 会社名リストをString型でリストで返す
     */
    public List<String> getCompanyNames() {
        return createCompanySoshikiMapper.getCompanyNames();
    }

    /**
     * 組織名を取得するメソッド
     * このメソッドはCreateCompanySoshikiMapperを呼び出して、
     * TAISYO_SOSHIKIテーブルから組織名を取得する
     * 
     * @return 組織名リストをString型でリストで返す
     */
    public List<String> getSoshikiNames() {
        return createCompanySoshikiMapper.getSoshikiNames();
    }

    /**
     * 新たなユーザーを生成するメソッド
     * このメソッドはCreateCompanySoshikiMapperを呼び出して、
     * Usersテーブルに新しいユーザーを挿入する。
     * 
     * @param user Userオブジェクト。 
     * UserオブジェクトにはuserId、name、companyName、organizationName、kengenKubunのフィールドが含まれる。
     */
    public void CreateUser(User user) {
        createCompanySoshikiMapper.createUser(user);
    }

    public List<User> getUsersWithCompanyAndOrganization() {
        return createCompanySoshikiMapper.getUsersWithCompanyAndOrganization();
    }
}
