package com.tcc.main.domain.local.profile;

public class RoleProfile {
    private Long rpId;

    private Long usId;

    private String rpHeader;

    private Integer rpSex;

    private String rpNickName;

    private String rpEmail;

    private Integer rpAge;

    private String rpCompany;

    private String rpOccupation;

    private String rpIndustry;

    private String rpTimeCreate;

    private String rpTimeModify;

    private Integer rpYn;

    public Long getRpId() {
        return rpId;
    }

    public void setRpId(Long rpId) {
        this.rpId = rpId;
    }

    public Long getUsId() {
        return usId;
    }

    public void setUsId(Long usId) {
        this.usId = usId;
    }

    public String getRpHeader() {
        return rpHeader;
    }

    public void setRpHeader(String rpHeader) {
        this.rpHeader = rpHeader == null ? null : rpHeader.trim();
    }

    public Integer getRpSex() {
        return rpSex;
    }

    public void setRpSex(Integer rpSex) {
        this.rpSex = rpSex;
    }

    public String getRpNickName() {
        return rpNickName;
    }

    public void setRpNickName(String rpNickName) {
        this.rpNickName = rpNickName == null ? null : rpNickName.trim();
    }

    public String getRpEmail() {
        return rpEmail;
    }

    public void setRpEmail(String rpEmail) {
        this.rpEmail = rpEmail == null ? null : rpEmail.trim();
    }

    public Integer getRpAge() {
        return rpAge;
    }

    public void setRpAge(Integer rpAge) {
        this.rpAge = rpAge;
    }

    public String getRpCompany() {
        return rpCompany;
    }

    public void setRpCompany(String rpCompany) {
        this.rpCompany = rpCompany == null ? null : rpCompany.trim();
    }

    public String getRpOccupation() {
        return rpOccupation;
    }

    public void setRpOccupation(String rpOccupation) {
        this.rpOccupation = rpOccupation == null ? null : rpOccupation.trim();
    }

    public String getRpIndustry() {
        return rpIndustry;
    }

    public void setRpIndustry(String rpIndustry) {
        this.rpIndustry = rpIndustry == null ? null : rpIndustry.trim();
    }

    public String getRpTimeCreate() {
        return rpTimeCreate;
    }

    public void setRpTimeCreate(String rpTimeCreate) {
        this.rpTimeCreate = rpTimeCreate;
    }

    public String getRpTimeModify() {
        return rpTimeModify;
    }

    public void setRpTimeModify(String rpTimeModify) {
        this.rpTimeModify = rpTimeModify;
    }

    public Integer getRpYn() {
        return rpYn;
    }

    public void setRpYn(Integer rpYn) {
        this.rpYn = rpYn;
    }
}