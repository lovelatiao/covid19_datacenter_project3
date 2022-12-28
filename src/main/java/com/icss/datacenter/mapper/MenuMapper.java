package com.icss.datacenter.mapper;

import com.icss.datacenter.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 只要是对菜单的数据操作
 */
@Repository
public interface MenuMapper {

    /**
     * 从数据库中查询得到所有的菜单列表
     * @return
     */
    public List<Menu> selectAll();

}
