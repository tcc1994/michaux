package com.tcc.main.domain.local.user;

public class UserSso {
    private Long usId;

    private Long usPhone;

    private String usAccount;

    private String usPasswd;

    private String usSecret;

    private Integer usRegClient;

    private Integer usFrozen;

    private String usTimeCreate;

    private String usTimeModify;

    private Integer usYn;

    public Long getUsId() {
        return usId;
    }

    public void setUsId(Long usId) {
        this.usId = usId;
    }

    public Long getUsPhone() {
        return usPhone;
    }

    public void setUsPhone(Long usPhone) {
        this.usPhone = usPhone;
    }

    public String getUsAccount() {
        return usAccount;
    }

    public void setUsAccount(String usAccount) {
        this.usAccount = usAccount == null ? null : usAccount.trim();
    }

    public String getUsPasswd() {
        return usPasswd;
    }

    public void setUsPasswd(String usPasswd) {
        this.usPasswd = usPasswd == null ? null : usPasswd.trim();
    }

    public String getUsSecret() {
        return usSecret;
    }

    public void setUsSecret(String usSecret) {
        this.usSecret = usSecret == null ? null : usSecret.trim();
    }

    public Integer getUsRegClient() {
        return usRegClient;
    }

    public void setUsRegClient(Integer usRegClient) {
        this.usRegClient = usRegClient;
    }

    public Integer getUsFrozen() {
        return usFrozen;
    }

    public void setUsFrozen(Integer usFrozen) {
        this.usFrozen = usFrozen;
    }

    public String getUsTimeCreate() {
        return usTimeCreate;
    }

    public void setUsTimeCreate(String usTimeCreate) {
        this.usTimeCreate = usTimeCreate;
    }

    public String getUsTimeModify() {
        return usTimeModify;
    }

    public void setUsTimeModify(String usTimeModify) {
        this.usTimeModify = usTimeModify;
    }

    public Integer getUsYn() {
        return usYn;
    }

    public void setUsYn(Integer usYn) {
        this.usYn = usYn;
    }
}