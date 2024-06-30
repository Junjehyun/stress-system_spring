package com.ptsol.stress_system.model;

import lombok.Data;

/**
 * HyojiSearchクラスは、検索条件を保持するクラス
 * 
 * このクラスは、検索条件を保持するためのクラスであり、
 * ユーザー情報を検索する際に使用される。
 */
@Data
public class HyojiSearch {
    
    private String userId;
    private String name;
    private String kaisyaCode;
    private String soshikiCode;
    private String companyName;
    private String organizationName;
    private Integer kengenKubun;
}
