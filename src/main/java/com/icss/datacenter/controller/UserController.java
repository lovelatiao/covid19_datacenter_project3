package com.icss.datacenter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.datacenter.entity.Role;
import com.icss.datacenter.entity.SysUser;
import com.icss.datacenter.service.IRoleService;
import com.icss.datacenter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private IRoleService roleService;

    /**
     * 展现登录页面
     * @return 跳转到的视图名称
     */
    @RequestMapping("/login.html")
    public String toLogin(){
        return "login";
    }

    /**
     * 展现用户列表(能实现带有过滤条件查询的分页列表展现)
     * @param searchUser 过滤查询条件
     * @param currentPage 展现的页码
     * @return
     */
    @RequestMapping("/userList")
    public ModelAndView toList(SysUser searchUser,Integer currentPage){
        ModelAndView modelAndView = new ModelAndView("user/userList");
        //默认展现首页
        if(currentPage==null){
            currentPage = 1;
        }
        Integer pageSize = 3;
        //告知分页已知条件
        PageHelper.startPage(currentPage,pageSize);
        //需要有一个能够帮助我们实现获取得到所有满足过滤条件的用户列表的业务逻辑——》即调用IUserService中的findList方法
        List<SysUser> userList =  userService.findList(searchUser);
        //使用PageInfo进行对分页结果的包装
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList);
        //将得到的分页结果传递到下一个资源上去
        modelAndView.addObject("pageInfo",pageInfo);
        //将过滤条件传递到页面资源上去
        modelAndView.addObject("searchUser",searchUser);
        return modelAndView;
    }

    /**
     * 展现添加用户页面
     * @param model 用于实现数据的传递
     * @return
     */
    @RequestMapping("/addUser.html")
    public String toAddUser(Model model){
        //需要获取得到所有的角色列表——》即调用IRoleService中的findAll方法即可
        List<Role> roleList = roleService.findAll();
        //将得到的角色列表传递到下一个资源上去
        model.addAttribute("roleList",roleList);
        return "user/addUser";
    }

    /**
     * 保存用户信息
     * @param userParam 要添加的用户信息
     * @return
     */
    @RequestMapping("/saveUser")
    public String toSaveUser(SysUser userParam,Model model){
        //需要有一个能够帮助我们实现保存用户信息的业务逻辑
        boolean flag = userService.saveUser(userParam);
        if(flag){ //如果保存成功，则展现用户列表
            return "forward:/userList";
        }else{//如果保存失败，则展现添加用户页面，并给出错误提示
            model.addAttribute("msg","用户名已被占用");
            return "forward:/addUser.html";
        }
    }


    /**
     * 删除指定编号的用户
     * @param uid 指定要删除的用户编号
     * @return
     */
    @RequestMapping("/deleteUser")
    public String toDelete(Integer uid){
        //需要有一个能够帮助我们实现删除指定编号的用户的业务逻辑
        userService.deleteUser(uid);
        return "forward:/userList";
    }

    /**
     * 批量删除指定的多个用户
     * @param uids 要删除的多个用户编号，每个编号之间采用逗号进行了连接
     * @return
     */
    @RequestMapping("/deleteUsers")
    public String toDeletes(String uids){
        //需要有一个能够帮助我们实现批量删除用户的业务逻辑
        userService.deleteUsers(uids);
        return "forward:/userList";
    }



    /**
     * 展现修改用户页面
     * @param uid 指定要修改的用户编号
     * @return
     */
    @RequestMapping("/updateUser.html")
    public ModelAndView toUpdateUser(Integer uid){
        ModelAndView modelAndView = new ModelAndView("user/updateUser");
        //需要获取得到指定要修改的用户信息，即通过指定的用户编号获取得到用户信息即可
        SysUser user = userService.findByUid(uid);
        //将用户信息传递到下一个资源上去
        modelAndView.addObject("user",user);
        //需要获取得到角色列表
        List<Role> roleList = roleService.findAll();
        modelAndView.addObject("roleList",roleList);
        return modelAndView;
    }

    /**
     * 修改用户信息
     * @param userParam 修改后的用户信息
     * @return
     */
    @RequestMapping("/updateUser")
    public ModelAndView updateUser(SysUser userParam){
        ModelAndView modelAndView = new ModelAndView();
        //需要有一个能够帮助我们实现修改指定用户信息的业务逻辑
        boolean flag = userService.updateUser(userParam);
        //通过得到的不同结果，给出用户不同的响应
        if(flag){//如果走进该if判断中，证明flag的值为true
            //跳转到展现用户列表的处理器上
            modelAndView.setViewName("forward:/userList");
        }else{//证明flag的值为false
            //传递错误提示
            modelAndView.addObject("msg","该用户名已被占用");
            //跳转到展现修改用户页面的处理器上
            modelAndView.setViewName("forward:/updateUser.html");
        }
        return modelAndView;
    }

    /**
     * 展现指定用户的详情
     * @param uid 指定的用户编号
     * @return
     */
    @RequestMapping("/detailUser")
    public ModelAndView toUserDetail(Integer uid){
        ModelAndView modelAndView = new ModelAndView("user/detailUser");
        //需要获取得到指定用户编号的用户信息
        SysUser user = userService.findByUid(uid);
        //将获取到的用户信息传递到下一个资源上去
        modelAndView.addObject("user",user);
        return modelAndView;
    }

}
