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
     * 查询得到所有满足过滤条件的用户列表
     * @param searchUser 过滤条件
     * @return 查询到的用户列表
     */
    public List<SysUser> selectList(SysUser searchUser);

    /**
     * 通过指定的用户名查询用户信息
     * @param username 指定的用户名
     * @return 查找到的用户信息
     */
    public SysUser selectByUsername(String username);


    /**
     * 向用户表中插入一条用户信息记录
     * @param userParam 指定要插入的用户信息
     */
    public void insertUser(SysUser userParam);

    /**
     * 删除指定编号的用户
     * @param uid 指定要删除的用户编号
     */
    public void deleteByUid(Integer uid);

    /**
     * 通过指定的用户编号查询得到用户信息
     * @param uid 指定的用户编号
     * @return 查询到的用户信息
     */
    public SysUser selectByUid(Integer uid);

    /**
     * 从数据库中修改指定的用户信息
     * @param userParam 修改后的用户信息
     */
    public void updateUser(SysUser userParam);

    /**
     * 从数据库中删除指定角色编号下的用户
     * @param rid 指定的角色编号
     */
    public void deleteByRid(Integer rid);

    /**
     * 从数据库中删除指定多个角色编号下的用户
     * @param rids 指定的多个角色编号
     */
    public void deleteByRids(String rids);


}
