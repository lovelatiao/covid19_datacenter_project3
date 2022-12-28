package com.icss.datacenter.controller;

import com.icss.datacenter.entity.SysUser;
import com.icss.datacenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 只要是和用户相关的处理器
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 展现登录页面
     * @return 跳转到的视图名称
     */
    @RequestMapping("/login.html")
    public String toLogin(){
        return "login";
    }

    /**
     * 展现用户列表
     * @return
     */
    @RequestMapping("/userList")
    public ModelAndView toList(){
        ModelAndView modelAndView = new ModelAndView("user/userList");
        //需要有一个能够帮助我们实现获取得到用户列表的业务逻辑——》即调用IUserService中的findList方法
        List<SysUser> userList =  userService.findList();
        //将得到的用户列表传递到下一个资源上去
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }


}
