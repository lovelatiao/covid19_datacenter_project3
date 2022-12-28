package com.icss.datacenter.service.impl;

import com.icss.datacenter.entity.Role;
import com.icss.datacenter.mapper.RoleMapper;
import com.icss.datacenter.mapper.UserMapper;
import com.icss.datacenter.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色的业务逻辑接口的实现类
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Role> findAll() {
        //从数据库中查询得到所有的角色列表——》即调用RoleMapper中的selectAll方法即可
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> findList(Role searchRole) {
        //从数据库查询得到所有满足过滤条件的角色列表
        return roleMapper.selectList(searchRole);
    }

    @Override
    public void deleteRole(Integer rid) {
        //从数据库中删除指定角色下的用户，即删除指定角色编号下的用户
        userMapper.deleteByRid(rid);
        //从数据库中删除指定角色拥有的菜单权限
        roleMapper.deleteRoleMenuByRid(rid);
        //从数据库中删除指定编号的角色
        roleMapper.deleteByRid(rid);
    }

    @Override
    public boolean saveRole(Role roleParam, String menuIds) {
        //通过指定的角色名称查找角色信息（目的是为了验证要插入的角色名称是否被占用）
        Role role = roleMapper.selectByRname(roleParam.getRname());
        //如果没有查询到角色信息，证明该角色名可用
        if(role==null){
            //向数据库中的角色表插入指定的角色信息记录
            roleMapper.insertRole(roleParam);
            //向数据库中的角色菜单的关联关系表中插入该角色拥有的菜单权限记录
            //（具体插入多少条关系记录，取决于选中了多少个菜单编号）
            String[] menuIdArray = menuIds.split(",");
            for(String menuId:menuIdArray){
                roleMapper.insertRoleMenu(roleParam.getRid(), Integer.parseInt(menuId));
            }
            //新增成功，则返回true
            return true;
        }
        //如果查询到角色信息，证明该角色名不可用，则新增失败，返回false
        return false;
    }

    @Override
    public void deleteRoles(String rids) {
        //从数据库中删除指定的多个角色编号下的用户列表
        userMapper.deleteByRids(rids);
        //从数据库中删除指定的多个角色编号下的关联菜单数据
        roleMapper.deleteRoleMenuByRids(rids);
        //从数据库中删除指定的多条角色信息
        roleMapper.deleteByRids(rids);
    }

    @Override
    public Role findByRid(Integer rid) {
        //从数据库中查询得到指定角色编号的角色信息
        return roleMapper.selectByRid(rid);
    }

    @Override
    public List<Integer> findMidsByRid(Integer rid) {
        //从数据库中查询得到指定角色编号拥有的所有的菜单编号列表
        return roleMapper.selectMidsByRid(rid);
    }

    @Override
    public boolean updateRole(Role roleParam, String menuIds) {
        //从数据库中通过指定的角色名称查询角色信息
        Role role = roleMapper.selectByRname(roleParam.getRname());
        //情况一：没有查询到角色信息
        //情况二：查询到了角色信息，但是该角色信息就是当前要修改的角色
        if(role==null || (role!=null && role.getRid()==roleParam.getRid())){
            //从数据库中修改指定角色的角色信息
            roleMapper.updateRole(roleParam);
            //从数据库中删除指定角色的原拥有的菜单权限
            roleMapper.deleteRoleMenuByRid(roleParam.getRid());
            //从数据库中添加该角色重新拥有的菜单权限
            String[] menuIdArray = menuIds.split(",");
            for(String menuId:menuIdArray){
                roleMapper.insertRoleMenu(roleParam.getRid(), Integer.parseInt(menuId));
            }
            //修改成功，返回true
            return true;
        }
        //如果查询到角色信息且查询到的角色信息也不是当前要修改的角色，证明该角色名已被占用，修改失败，返回false
        return false;
    }

}
