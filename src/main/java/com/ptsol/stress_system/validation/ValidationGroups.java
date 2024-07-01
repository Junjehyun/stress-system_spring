package com.ptsol.stress_system.validation;

/**
 * バリデーショングループのインターフェース
 * 
 * Createグループ：新規登録時のバリデーション
 * Updateグループ：更新時のバリデーション
 */
public interface ValidationGroups {
    interface Create {}
    interface Update {}
}
