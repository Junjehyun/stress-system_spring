package com.ptsol.stress_system.model;

import com.ptsol.stress_system.validation.ValidationGroups;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


/**
 * ユーザ情報を保持するクラス
 * 
 * @Dataアノテーションを付与することで、LombokによりGetter/Setterメソッドを自動生成する
 */
@Data

public class User {
    /**
     * Create項目にValidationチェックを追加
     */
    @NotEmpty(message = "ユーザIDは必須です", groups = ValidationGroups.Create.class)
    @Size(max = 10, message = "ユーザIDは10文字以内で入力してください", groups = ValidationGroups.Create.class)
    private String userId;

    @NotNull(message = "権限区分は必須です", groups = { ValidationGroups.Create.class, ValidationGroups.Update.class })
    private Integer kengenKubun;

    @NotEmpty(message = "権限区分チェックは必須です", groups = ValidationGroups.Create.class)
    private String kengenCheck;

    @NotEmpty(message = "名前は必須です", groups = { ValidationGroups.Create.class, ValidationGroups.Update.class })
    @Size(max = 10, message = "名前は10文字以内で入力してください", groups = { ValidationGroups.Create.class, ValidationGroups.Update.class })
    private String name;

    @NotEmpty(message = "会社名は必須です", groups = ValidationGroups.Create.class)
    private String kaisyaCode;
    @NotEmpty(message = "組織名は必須です", groups = ValidationGroups.Create.class)
    private String soshikiCode;

    private String companyName; // 追加
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
    
}
