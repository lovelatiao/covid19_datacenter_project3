package com.icss.datacenter.service.impl;

import com.icss.datacenter.entity.SysUser;
import com.icss.datacenter.mapper.UserMapper;
import com.icss.datacenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 只要是有关用户的业务逻辑接口的实现类
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<SysUser> findList(SysUser searchUser) {
        //从数据库中查询得到所有满足过滤条件的用户列表——》即调用UserMapper中的selectList方法
        return userMapper.selectList(searchUser);
    }

    @Override
    public boolean saveUser(SysUser userParam) {
        //通过指定的用户名查找用户信息（目的：验证要添加的用户的用户名是否已被占用）
        SysUser user = userMapper.selectByUsername(userParam.getUsername());
        //如果没有查找到用户信息，证明用户名可用
        if(user==null){
            //则向数据库中的用户表插入一条用户信息记录，返回true
            userMapper.insertUser(userParam);
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(Integer uid) {
        //从数据库中删除指定编号的用户
        userMapper.deleteByUid(uid);
    }

    @Override
    public void deleteUsers(String uids) {
        String[] uidArray = uids.split(",");
        for(String uid:uidArray){
            userMapper.deleteByUid(Integer.parseInt(uid));
        }
    }

    @Override
    public SysUser findByUid(Integer uid) {
        //从数据库中通过指定的用户编号查询得到用户信息
        return userMapper.selectByUid(uid);
    }

    @Override
    public boolean updateUser(SysUser userParam) {
        //通过指定的用户名查找用户信息（目的是为了验证修改后的用户名是否被占用）
        SysUser user = userMapper.selectByUsername(userParam.getUsername());
        //情况一：如果没有查询到用户信息
        //情况二：如果查询到了用户信息，但是查询到的用户信息就是当前要修改的用户
        if(user==null || (user!=null && user.getUid()== userParam.getUid())){
            //证明该用户名可用，则从数据库中修改指定的用户信息
            userMapper.updateUser(userParam);
            //返回true
            return true;
        }
        //证明该用户名已被占用，则修改失败，返回false
        return false;
    }

}
