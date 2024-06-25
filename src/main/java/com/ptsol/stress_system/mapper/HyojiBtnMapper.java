package com.ptsol.stress_system.mapper;

import com.ptsol.stress_system.model.HyojiSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * HyojiBtnMapperはユーザー情報をデータベースから検索するメソッドを含むインターフェース
 * MyBatisマッパーインターフェースで、SQLマッピングファイル(hyojiBtnMapper.xml)と接続される。
 * 
 */
@Mapper
public interface HyojiBtnMapper {
    /**
     * ユーザーの情報を検索するメソッド
     * 
     * @param companyNameSelected 会社名
     * @param soshikiNameSelected 組織名
     * @param kengenKubun 権限区分
     * return ユーザー情報 (取得情報)
     */
    List<HyojiSearch> hyojiSearchUsers(
    @Param("companyNameSelected") String companyNameSelected,
    @Param("soshikiNameSelected") String soshikiNameSelected,
    @Param("kengenKubun") Integer kengenKubun);
}
