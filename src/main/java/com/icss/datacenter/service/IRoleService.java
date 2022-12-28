package com.icss.datacenter.service;

import com.icss.datacenter.entity.Role;

import java.util.List;

/**
 * 只要是和角色相关的业务逻辑接口
 */
public interface IRoleService {

    /**
     * 获取得到所有的角色列表
     * @return 得到的角色列表
     */
    public List<Role> findAll();

    /**
     * 获取得到所有满足过滤条件的角色列表
     * @param searchRole 过滤条件
     * @return 满足过滤条件的角色列表
     */
    public List<Role> findList(Role searchRole);

    /**
     * 删除指定编号的角色的业务逻辑
     * @param rid 指定的角色编号
     */
    public void deleteRole(Integer rid);

    /**
     * 保存角色信息
     * @param roleParam 要保存的角色信息
     * @param menuIds 该角色关联的菜单权限列表
     * @return
     */
    public boolean saveRole(Role roleParam,String menuIds);

    /**
     * 删除指定的多个编号的角色
     * @param rids 指定的多个角色编号
     */
    public void deleteRoles(String rids);

    /**
     * 获取得到指定角色编号的角色信息
     * @param rid 指定的角色编号
     * @return 获取到的角色信息
     */
    public Role findByRid(Integer rid);

    /**
     * 获取得到指定角色编号拥有的菜单编号列表
     * @param rid 指定的角色编号
     * @return 该角色拥有的所有菜单编号列表
     */
    public List<Integer> findMidsByRid(Integer rid);

    /**
     * 修改指定角色信息
     * @param roleParam 修改后的角色信息
     * @param menuIds 修改后的角色拥有的菜单权限
     * @return true代表修改成功，false代表修改失败
     */
    public boolean updateRole(Role roleParam,String menuIds);

}







