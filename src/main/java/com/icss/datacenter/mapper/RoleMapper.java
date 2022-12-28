package com.icss.datacenter.mapper;

import com.icss.datacenter.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 只要是有关角色的数据操作
 */
@Repository
public interface RoleMapper {

    /**
     * 查询得到所有的角色列表
     * @return 得到的角色列表
     */
    public List<Role> selectAll();


    /**
     * 查询得到所有满足过滤条件的角色列表
     * @param searchRole 过滤条件
     * @return 查询得到的角色列表
     */
    public List<Role> selectList(Role searchRole);

    /**
     * 从数据库中删除指定角色编号下的菜单权限
     * @param rid 指定的角色编号
     */
    public void deleteRoleMenuByRid(Integer rid);

    /**
     * 从数据库中删除指定编号的角色
     * @param rid 指定的角色编号
     */
    public void deleteByRid(Integer rid);

    /**
     * 通过指定的角色名称查询角色信息
     * @param rname 指定的角色名称
     * @return 查找到的角色信息
     */
    public Role selectByRname(String rname);


    /**
     * 向数据库中插入指定的一条角色信息记录
     * @param roleParam 要插入的角色信息
     */
    public void insertRole(Role roleParam);

    /**
     * 向数据库中角色和菜单的关联关系表中插入关系记录
     * @param rid 角色编号
     * @param mid 菜单编号
     */
    public void insertRoleMenu(@Param("rid") Integer rid, @Param("mid") Integer mid);

    /**
     * 从数据库中删除指定的多个角色编号下的关联菜单数据
     * @param rids 指定的多个角色编号
     */
    public void deleteRoleMenuByRids(String rids);

    /**
     * 从数据库中删除指定的多个编号下的角色
     * @param rids 指定的多个角色编号
     */
    public void deleteByRids(String rids);

    /**
     * 从数据库中查询指定角色编号下的角色信息
     * @param rid 指定的角色编号
     * @return 查询到的角色信息
     */
    public Role selectByRid(Integer rid);

    /**
     * 从数据库中查询得到指定角色编号拥有的所有的菜单编号列表
     * @param  rid 指定的角色编号
     * @return 查询得到的指定角色编号下拥有的菜单编号列表
     */
    public List<Integer> selectMidsByRid(Integer rid);

    /**
     * 从数据库中修改指定编号的角色信息
     * @param roleParam 修改后的角色信息
     */
    public void updateRole(Role roleParam);



}
