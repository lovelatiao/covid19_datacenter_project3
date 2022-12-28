package com.icss.datacenter.service;

import com.icss.datacenter.entity.SysUser;

import java.util.List;

/**
 * 只要是有关用户的业务逻辑接口
 */
public interface IUserService {

    /**
     * 获取得到所有满足过滤条件的用户列表
     * @param searchUser 过滤条件
     * @return 用户列表
     */
    public List<SysUser> findList(SysUser searchUser);

    /**
     * 保存用户信息
     * @param userParam 要保存的用户信息
     * @return true代表保存成功，false代表保存失败
     */
    public boolean saveUser(SysUser userParam);


    /**
     * 删除指定编号的用户
     * @param uid 指定要删除的用户编号
     */
    public void deleteUser(Integer uid);

    /**
     * 删除多个指定编号的用户
     * @param uids 要删除的多个用户编号，每个编号之间采用逗号进行了连接
     */
    public void deleteUsers(String uids);


    /**
     * 通过指定的用户编号获取得到用户信息
     * @param uid 指定的用户编号
     * @return 获取得到的用户信息
     */
    public SysUser findByUid(Integer uid);

    /**
     * 实现修改指定用户信息
     * @param userParam 修改后的用户信息
     * @return true代表修改成功，false代表修改失败
     */
    public boolean updateUser(SysUser userParam);


}
