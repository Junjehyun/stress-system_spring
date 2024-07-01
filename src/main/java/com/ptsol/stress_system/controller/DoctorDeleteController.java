package com.ptsol.stress_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptsol.stress_system.service.UserService;
/**
 * 医師削除コントローラクラス。
 */
@Controller
public class DoctorDeleteController {

    @Autowired
    private UserService userService;

    /**
     * 医師削除処理を行うメソッド。
     * 
     * @param userId 削除対象のユーザID
     * @return 削除結果
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam("userId") String userId) {
        System.out.println("DELETE 요청 수신: userId=" + userId); // 디버그 로그 추가
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("삭제 중 오류 발생: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
