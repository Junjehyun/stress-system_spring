package com.ptsol.stress_system.model;

import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * ユーザ情報を保持するクラス

 */
@Data
public class User {
    /**
     * Create項目にValidationチェックを追加
     */
    @NotEmpty(message = "ユーザIDは必須です")
    @Size(max = 10, message = "ユーザIDは10文字以内で入力してください")
    private String userId;
    @NotNull(message = "権限区分は必須です")
    private Integer kengenKubun;
    @NotEmpty(message = "名前は必須です")
    @Size(max = 10, message = "名前は10文字以内で入力してください")
    private String name;
    @NotEmpty(message = "会社名は必須です")
    private String companyName; // 追加
    @NotEmpty(message = "組織名は必須です")
    private String organizationName; // 追加

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
    @NotEmpty(message = "会社名は必須です")
    private String kaisyaCode;
    @NotEmpty(message = "組織名は必須です")
    private String soshikiCode;
}
