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
     * ユーザー情報を検索するサービスメソッド
     * 
     * ＠Param companyName 会社名
     * ＠Param soshikiName 組織名
     * ＠Param kengenKubun 権限区分
     * ＠return 検索されたユーザーリスト（HyojiSearchオブジェクトのリスト）
     */
    public List<HyojiSearch> hyojiSearchUsers
    (
        String companyNameSelected,
        String soshikiNameSelected,
        Integer kengenKubun
    ) 
    {   return hyojiBtnMapper.hyojiSearchUsers(
            companyNameSelected, 
            soshikiNameSelected, 
            kengenKubun
        );
    }

}
