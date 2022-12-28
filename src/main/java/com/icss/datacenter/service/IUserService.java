package com.icss.datacenter.service;

import com.icss.datacenter.entity.SysUser;

import java.util.List;

/**
 * 只要是有关用户的业务逻辑接口
 */
public interface IUserService {

    /**
     * 获取得到用户列表
     * @return 用户列表
     */
    public List<SysUser> findList();

}
