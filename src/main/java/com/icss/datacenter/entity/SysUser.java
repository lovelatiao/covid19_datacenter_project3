package com.icss.datacenter.entity;

/**
 * 系统用户实体类
 */
public class SysUser {

    private Integer uid;//用户编号
    private String username;//用户名
    private String password;//密码
    private Integer rid;//所属的角色编号

    //代表该用户所属的角色信息
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
