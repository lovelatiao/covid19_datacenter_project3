package com.icss.datacenter.service;

import com.icss.datacenter.entity.Menu;

import java.util.List;

/**
 * 只要是有关菜单的业务逻辑接口
 */
public interface IMenuService {

    /**
     * 获取得到所有的菜单列表
     * @return
     */
    public List<Menu> findAll();

}
