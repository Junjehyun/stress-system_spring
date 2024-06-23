package com.ptsol.stress_system.model;

/**
 * HyojiSearchクラスは、検索条件を保持するクラス
 */
public class HyojiSearch {
    private String userId;
    private String name;
    private String companyName;
    private String organizationName;
    private Integer kengenKubun;

    // Getter and Setter

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getKengenKubun() {
        return kengenKubun;
    }

    public void setKengenKubun(Integer kengenKubun) {
        this.kengenKubun = kengenKubun;
    }
}
