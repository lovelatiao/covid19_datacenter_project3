package com.icss.datacenter.controller;

import com.icss.datacenter.entity.Menu;
import com.icss.datacenter.entity.Tree;
import com.icss.datacenter.service.IMenuService;
import com.icss.datacenter.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 只要是有关菜单的处理器
 */
@Controller
public class MenuController {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private IRoleService roleService;

    /**
     * 异步请求：获取得到所有的树状的菜单列表
     * @param rid 指定要修改的角色编号(目的是为了让指定该角色拥有的菜单默认为选中状态)
     * @return
     */
    @RequestMapping("/treeList")
    @ResponseBody
    public List<Tree> treeList(Integer rid){
        //需要有一个能够帮助我们实现获取得到所有菜单列表的业务逻辑
        List<Menu> menuList = menuService.findAll();
        List<Integer> menuIds = null;
        if(rid!=null){
            //需要有一个能够帮助我们实现获取得到指定角色编号拥有的菜单编号列表的业务逻辑
            menuIds = roleService.findMidsByRid(rid);
        }
        //将得到的菜单列表封装成List<Tree>
        List<Tree> treeList = new ArrayList<>();
        for(Menu menu:menuList){
            if(menu.getLevel()==1){
                //把Menu对象封装成Tree对象，放在treeList集合当中
                Tree treeNode = new Tree();
                treeNode.setId(menu.getMid());
                treeNode.setName(menu.getMname());
                //如果当前的菜单是指定角色拥有的菜单，则设置checked属性值为true
                if(menuIds!=null && menuIds.contains(menu.getMid())){
                    treeNode.setChecked(true);
                }
                setChild(treeNode,menuList,menuIds);
                treeList.add(treeNode);
            }
        }
        return treeList;
    }

    /**
     * 提取方法：实现设置指定菜单的孩子列表
     * @param treeNode 指定为哪个菜单设置孩子节点
     * @param menuList 所有的菜单列表，通过其去进行查询指定菜单下的孩子菜单列表
     * @param menuIds 指定角色拥有的所有的菜单编号列表(目的是为了验证孩子节点是否需要被选中)
     */
    public static void setChild(Tree treeNode,List<Menu> menuList,List<Integer> menuIds){
        List<Tree> childList = new ArrayList<>();
        for(Menu menu:menuList){ //在循环遍历的过程中，找到指定菜单的孩子菜单
            if(menu.getPmid()==treeNode.getId()){
                Tree childTree = new Tree();
                childTree.setId(menu.getMid());
                childTree.setName(menu.getMname());
                if(menuIds!=null && menuIds.contains(menu.getMid())){
                    childTree.setChecked(true);
                }
                //设置孩子列表
                setChild(childTree,menuList,menuIds);
                childList.add(childTree);
            }
        }
        if(childList.size()==0)
            return;
        //最后得到的childList就是指定菜单的所有的孩子菜单列表
        treeNode.setChildren(childList);
    }


}
