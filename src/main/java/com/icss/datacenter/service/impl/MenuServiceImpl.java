package com.icss.datacenter.service.impl;

import com.icss.datacenter.entity.Menu;
import com.icss.datacenter.mapper.MenuMapper;
import com.icss.datacenter.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 只要是有关菜单的业务逻辑接口的实现类
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findAll() {
        //从数据库中查询得到所有的菜单列表
        return menuMapper.selectAll();
    }

}
