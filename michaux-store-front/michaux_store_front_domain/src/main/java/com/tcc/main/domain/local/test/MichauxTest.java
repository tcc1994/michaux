package com.tcc.main.domain.local.test;

public class MichauxTest {
    private Long mtId;

    private String mtInfo;

    private String createDatetime;

    public Long getMtId() {
        return mtId;
    }

    public void setMtId(Long mtId) {
        this.mtId = mtId;
    }

    public String getMtInfo() {
        return mtInfo;
    }

    public void setMtInfo(String mtInfo) {
        this.mtInfo = mtInfo == null ? null : mtInfo.trim();
    }

    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }
}