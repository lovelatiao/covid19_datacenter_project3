package com.icss.datacenter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.datacenter.entity.Role;
import com.icss.datacenter.entity.Tree;
import com.icss.datacenter.service.IRoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 只要是有关角色的处理器
 */
@Controller
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 分页展现角色列表
     * @param searchRole 过滤条件
     * @param currentPage 展现的页码
     * @return
     */
    @RequestMapping("/roleList")
    public ModelAndView toList(Role searchRole,Integer currentPage){
        ModelAndView modelAndView = new ModelAndView("role/roleList");
        //对展现的页面进行处理
        if(currentPage==null){
            currentPage = 1;//默认展现第1页
        }
        //自定义每页展现的条数
        Integer pageSize = 3;
        //告知分页的已知条件
        PageHelper.startPage(currentPage,pageSize);
        //需要获取得到所有满足过滤条件的角色列表
        List<Role> roleList = roleService.findList(searchRole);
        //使用PageInfo对分页的结果进行包装
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        //将分页数据传递到下一个资源上去
        modelAndView.addObject("pageInfo",pageInfo);
        //把搜索条件传递到下一个资源上去
        modelAndView.addObject("searchRole",searchRole);
        return modelAndView;
    }

    /**
     * 删除指定编号的角色
     * @param rid 指定的角色编号
     * @return
     */
    @RequestMapping("/deleteRole")
    public String toDeleteRole(Integer rid){
        //需要有一个能够帮助我们实现删除指定编号的角色的业务逻辑
        roleService.deleteRole(rid);
        return "forward:/roleList";
    }

    /**
     * 展现添加角色页面
     * @return
     */
    @RequestMapping("/addRole.html")
    public String toAddRole(){
        return "role/addRole";
    }

    /**
     * 保存角色信息
     * @param roleParam 要添加的角色信息
     * @param menuIds 该角色指定关联的菜单编号列表
     * @param model 用于数据传递
     * @return
     */
    @RequestMapping("/saveRole")
    public String toSaveRole(Role roleParam, String menuIds, Model model){
        //需要有一个能够帮助我们实现保存角色信息的业务逻辑
        boolean flag = roleService.saveRole(roleParam,menuIds);
        //通过判断返回值，给出不同的响应
        if(flag){//如果走进该if判断中，证明flag的值为true
            //展现角色列表
            return "forward:/roleList";
        }else{//证明flag的值为false
            //传递错误提示
            model.addAttribute("msg","该角色名已被占用");
            //展现添加角色页面
            return "role/addRole";
        }
    }

    /**
     * 批量删除指定的多个角色
     * @param rids 多个指定要删除的角色编号
     * @return
     */
    @RequestMapping("/deleteRoles")
    public String toDeleteRoles(String rids){
        //需要有一个能够帮助我们实现批量删除指定的多个角色的业务逻辑
        roleService.deleteRoles(rids);
        //跳转到角色列表页面
        return "forward:/roleList";
    }

    /**
     * 展现修改角色页面
     * @param rid 指定要修改的角色编号
     * @return
     */
    @RequestMapping("/updateRole.html")
    public ModelAndView toUpdateRole(Integer rid){
        ModelAndView modelAndView = new ModelAndView("role/updateRole");
        //需要获取得到指定角色编号的角色信息
        Role role = roleService.findByRid(rid);
        //将得到的角色信息传递到下一个资源上去
        modelAndView.addObject("role",role);
        return modelAndView;
    }

    /**
     * 修改角色信息
     * @param roleParam 修改后的角色信息
     * @param menuIds 修改后的角色拥有的菜单权限列表
     * @param model 用于数据的传递
     * @return
     */
    @RequestMapping("/updateRole")
    public String updateRole(Role roleParam,String menuIds,Model model){
        //需要有一个能够帮助我们实现修改指定角色信息的业务逻辑
        boolean flag = roleService.updateRole(roleParam,menuIds);
        //根据得到的不同结果，给出用户不同的响应
        if(flag){//如果走进该if中，证明flag的值为true
            //跳转到展现角色列表的处理器上
            return "forward:/roleList";
        }else{//证明flag的值为false
            //传递错误提示到下一个资源上去
            model.addAttribute("msg","该角色名已被占用");
            //跳转到展现修改角色的页面上
            return "forward:/updateRole.html";
        }
    }


    /**
     * 展现指定角色编号的详情
     * @param rid 指定的角色编号
     * @return
     */
    @RequestMapping("/detailRole")
    public ModelAndView toRoleDetail(Integer rid){
        ModelAndView modelAndView = new ModelAndView("role/detailRole");
        //需要获取得到指定角色编号的角色信息
        Role role = roleService.findByRid(rid);
        //将得到的角色信息传递到下一个资源上去
        modelAndView.addObject("role",role);
        return modelAndView;
    }


}
