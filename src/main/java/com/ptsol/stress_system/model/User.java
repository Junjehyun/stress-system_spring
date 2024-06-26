package com.ptsol.stress_system.model;
import java.util.Date;

import lombok.Data;

/**
 * Userテーブルの各カラム名
 */
@Data
public class User {
    private String userId;
    private String userKubun;
    private String torokuDate;
    private String torokuCn;
    private String torokuTrm;
    private String koshinDate;
    private String koshinCn;
    private String koshinTrm;
    private String sakujoDate;
    private String sakujoCn;
    private String sakujoTrm;
    private String sakujoFlag;
    private Integer kengenKubun;
    private String kaisyaCode;
    private String soshikiCode;
    private String name;
    private String companyName; // 追加
    private String organizationName; // 追加

}
