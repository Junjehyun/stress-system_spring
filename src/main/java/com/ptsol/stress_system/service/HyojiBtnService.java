package com.ptsol.stress_system.service;

import com.ptsol.stress_system.mapper.HyojiBtnMapper;
import com.ptsol.stress_system.model.HyojiSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * HyojiBtnServiceクラスは、ビジネスロジックを処理するサービスクラス
 * HyojiBtnMapperを使用してデーターベースとのやり取りを行う
 */
@Service
public class HyojiBtnService {
    @Autowired
    private HyojiBtnMapper hyojiBtnMapper;

    /**
     * 検索条件による、ユーザーリストを取得するメソッド
     * ＠Param companyName 会社名
     * ＠Param soshikiName 組織名
     * ＠Param kengenKubun 権限区分
     * ＠return ユーザーリスト
     */
//    public List<HyojiSearch> hyojiSearchUsers
//        (
//                String companyName,
//                String soshikiName,
//                Integer KengenKubun
//        ) {
//        return hyojiBtnMapper.hyojiSearchUsers(companyName, soshikiName, KengenKubun);
//
//    }
    public List<HyojiSearch> hyojiSearchUsers(String companyName, String soshikiName, Integer kengenKubun) {
        List<HyojiSearch> users = hyojiBtnMapper.hyojiSearchUsers(companyName, soshikiName, kengenKubun);
        System.out.println("Service - Users: " + users); // 추가된 로그
        return users;
    }

}
