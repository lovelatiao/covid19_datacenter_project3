package com.icss.datacenter.entity;

/**
 * 时间疫情数据的实体类
 */
public class Internalday {

    private String dateId;  //日期
    private Integer confirmedIncr;  //新增确诊数量
    private Integer confirmedCount; //累计确诊数量
    private Integer suspectedCount; //疑似病例数量
    private Integer curedCount;  //治愈数量
    private Integer deadCount;   //死亡数量

    private String startDate; //过滤条件：起始时间
    private String endDate;   //过滤条件：结束时间

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public Integer getConfirmedIncr() {
        return confirmedIncr;
    }

    public void setConfirmedIncr(Integer confirmedIncr) {
        this.confirmedIncr = confirmedIncr;
    }

    public Integer getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public Integer getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(Integer suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public Integer getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(Integer curedCount) {
        this.curedCount = curedCount;
    }

    public Integer getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(Integer deadCount) {
        this.deadCount = deadCount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
