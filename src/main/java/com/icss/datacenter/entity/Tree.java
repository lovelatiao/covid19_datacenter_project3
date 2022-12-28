package com.icss.datacenter.entity;

import java.util.List;

/**
 * 树状菜单的实体类
 */
public class Tree {

    private Integer id; //菜单编号
    private String name; //菜单名称
    private boolean checked; //是否被选中
    private boolean open = true; //是否被展开
    private List<Tree> children; //孩子菜单列表

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }
}
