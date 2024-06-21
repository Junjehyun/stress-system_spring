package com.ptsol.stress_system.model;
import java.util.Date;

/**
 * Userテーブルの各カラム名
 */
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
    private String kengenKubun;
    private String kaisyaCode;
    private String soshikiCode;
    private String name;

    // getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserKubun() {
        return userKubun;
    }

    public void setUserKubun(String userKubun) {
        this.userKubun = userKubun;
    }

    public String getTorokuDate() {
        return torokuDate;
    }

    public void setTorokuDate(String torokuDate) {
        this.torokuDate = torokuDate;
    }

    public String getTorokuCn() {
        return torokuCn;
    }

    public void setTorokuCn(String torokuCn) {
        this.torokuCn = torokuCn;
    }

    public String getTorokuTrm() {
        return torokuTrm;
    }

    public void setTorokuTrm(String torokuTrm) {
        this.torokuTrm = torokuTrm;
    }

    public String getKoshinDate() {
        return koshinDate;
    }

    public void setKoshinDate(String koshinDate) {
        this.koshinDate = koshinDate;
    }

    public String getKoshinCn() {
        return koshinCn;
    }

    public void setKoshinCn(String koshinCn) {
        this.koshinCn = koshinCn;
    }

    public String getKoshinTrm() {
        return koshinTrm;
    }

    public void setKoshinTrm(String koshinTrm) {
        this.koshinTrm = koshinTrm;
    }

    public String getSakujoDate() {
        return sakujoDate;
    }

    public void setSakujoDate(String sakujoDate) {
        this.sakujoDate = sakujoDate;
    }

    public String getSakujoCn() {
        return sakujoCn;
    }

    public void setSakujoCn(String sakujoCn) {
        this.sakujoCn = sakujoCn;
    }

    public String getSakujoTrm() {
        return sakujoTrm;
    }

    public void setSakujoTrm(String sakujoTrm) {
        this.sakujoTrm = sakujoTrm;
    }

    public String getSakujoFlag() {
        return sakujoFlag;
    }

    public void setSakujoFlag(String sakujoFlag) {
        this.sakujoFlag = sakujoFlag;
    }

    public String getKengenKubun() {
        return kengenKubun;
    }

    public void setKengenKubun(String kengenKubun) {
        this.kengenKubun = kengenKubun;
    }

    public String getKaisyaCode() {
        return kaisyaCode;
    }

    public void setKaisyaCode(String kaisyaCode) {
        this.kaisyaCode = kaisyaCode;
    }

    public String getSoshikiCode() {
        return soshikiCode;
    }

    public void setSoshikiCode(String soshikiCode) {
        this.soshikiCode = soshikiCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
