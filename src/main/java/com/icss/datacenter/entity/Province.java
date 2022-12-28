package com.icss.datacenter.entity;

/**
 * 全国各个省份疫情数据的实体类
 */
public class Province {

    private String datetime;  //日期
    private Integer locationId; //省份编号
    private String provinceShortName; //省份名称
    private Integer currentConfirmedCount; //当前新增确诊数量
    private Integer confirmedCount; //累计确诊数量
    private Integer suspectedCount; //疑似病例数量
    private Integer curedCount; //治愈数量
    private Integer deadCount; //死亡数量

    //用于接收参数，接收到省份信息（既包含省份编号，又包含省份名称）。格式为：省份编号,省份名称
    private String provinceInfo;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public Integer getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(Integer currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
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

    public String getProvinceInfo() {
        return provinceInfo;
    }

    public void setProvinceInfo(String provinceInfo) {
        this.provinceInfo = provinceInfo;
    }
}
