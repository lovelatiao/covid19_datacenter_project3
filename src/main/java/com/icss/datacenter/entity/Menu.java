package com.icss.datacenter.entity;

/**
 * 菜单实体类
 */
public class Menu {

    private Integer mid;   //菜单编号
    private String mname;  //菜单名称
    private String murl;   //菜单链接地址
    private Integer pmid;  //父菜单编号
    private Integer level; //菜单等级
    private Integer sort;  //菜单排序
    private String identification; //菜单权限标识

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public Integer getPmid() {
        return pmid;
    }

    public void setPmid(Integer pmid) {
        this.pmid = pmid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
