package com.ptsol.stress_system.mapper;

import com.ptsol.stress_system.model.HyojiSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * このインタフェースはMyBatisのマッパーインタフェースで、
 * ユーザーの検索条件により、データーを取得するためのメソッドを定義
 */
@Mapper
public interface HyojiBtnMapper {
    /**
     * @param companyName 会社名
     * @param soshikiName 組織名
     * @param kengenKubun 権限区分
     * @return ユーザーリスト
     */
    List<HyojiSearch> hyojiSearchUsers(
            @Param("companyName") String companyName,
            @Param("soshikiName") String soshikiName,
            @Param("kengenKubun") Integer kengenKubun
    );
}
