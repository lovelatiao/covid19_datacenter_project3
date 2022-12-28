package com.icss.datacenter.controller;

import com.github.pagehelper.PageHelper;
import com.icss.datacenter.entity.Wz;
import com.icss.datacenter.service.IWzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author laohe
 * @company bigdata
 * @create 2022-12-28 9:52
 */
@Controller
public class WzController {
    @Autowired
    private IWzService wzService;
    @RequestMapping("/wzList")
    public ModelAndView wzList(Wz wzParm,Integer currentPage){
        ModelAndView modelAndView=new ModelAndView("wz/wzList");
        if(currentPage==null){
            currentPage=1;
        }
        PageHelper.startPage(currentPage,10);
        List<Wz> wzList= wzService.findByConditions(wzParm);
        for (Wz wz : wzList) {
            System.out.println(wz);
        }
        return modelAndView;
    }
}
