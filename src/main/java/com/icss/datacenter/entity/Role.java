package com.icss.datacenter.entity;

/**
 * 角色的实体类
 */
public class Role {

    private Integer rid; //角色编号
    private String rname; //角色名称
    private String rdesc; //角色描述

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }
}
