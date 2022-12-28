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
    public List<SysUser> findList() {
        //从数据库中查询得到用户列表——》即调用UserMapper中的selectList方法
        return userMapper.selectList();
    }

}
