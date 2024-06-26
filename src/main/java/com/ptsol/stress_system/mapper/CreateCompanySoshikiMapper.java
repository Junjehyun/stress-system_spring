package com.ptsol.stress_system.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ptsol.stress_system.model.User;
import java.util.List;


@Mapper
public interface CreateCompanySoshikiMapper {
    /**
     * KAISYA_MSTテーブルから会社名を取得する
     * 
     * @return KAISYA_NAME_JPNリストをString型でリストで返す
     */
    List<String> getCompanyNames();
    /**
     * TAISYO_SOSHIKIテーブルから組織名を取得する
     * 
     * @return SOSHIKI_NAME_JPNリストをString型でリストで返す
     */
    List<String> getSoshikiNames();

    /**
     * 新たなユーザーを生成するメソッド
     * このメソッドはMyBatisを通じてusersテーブルに新しいユーザーを挿入します。
     * 
     * @param user Userオブジェクト。
     * UserオブジェクトにはuserId、name、companyName、organizationName、kengenKubunのフィールドが含まれる。
     */
    void CreateUser(User user);
}
