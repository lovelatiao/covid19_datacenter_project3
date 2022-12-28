package com.icss.datacenter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.datacenter.entity.Internalday;
import com.icss.datacenter.service.IInternaldayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 只要是有关时间疫情数据的处理器
 */
@Controller
public class InternaldayController {

    @Autowired
    private IInternaldayService internaldayService;

    /**
     * 分页展现时间疫情数据列表
     * @param searchInternalday 过滤条件
     * @param currentPage 分页展现的页面
     * @return
     */
    @RequestMapping("/internaldayList")
    public ModelAndView toList(Internalday searchInternalday,Integer currentPage){
        ModelAndView modelAndView = new ModelAndView("internalday/internaldayList");
        if(currentPage==null){
            currentPage = 1;
        }
        Integer pageSize = 4;
        PageHelper.startPage(currentPage,pageSize);
        //需要有一个能够帮助我们获取得到所有满足过滤条件的时间疫情数据列表的业务逻辑
        List<Internalday> internaldayList = internaldayService.findList(searchInternalday);
        PageInfo<Internalday> pageInfo = new PageInfo<>(internaldayList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("searchInternalday",searchInternalday);
        return modelAndView;
    }

}
