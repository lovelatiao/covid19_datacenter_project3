package com.icss.datacenter.mapper;

import com.icss.datacenter.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 只要是有关用户的数据操作
 */
@Repository
public interface UserMapper {

    /**
     * 查询得到用户列表
     * @return 查询到的用户列表
     */
    public List<SysUser> selectList();

}
