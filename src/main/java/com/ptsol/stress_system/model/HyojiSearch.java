package com.ptsol.stress_system.model;

import lombok.Data;

/**
 * HyojiSearchクラスは、検索条件を保持するクラス
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

    // Getter and SetterはLombokで自動生成される

}
