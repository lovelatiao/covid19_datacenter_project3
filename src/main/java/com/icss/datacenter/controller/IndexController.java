package com.icss.datacenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 有关首页展现的处理器
 */
@Controller
public class IndexController {

    /**
     * 展现首页
     * @return 指定要跳转的视图名称
     */
    @RequestMapping("/main.html")
    public String toMain(){
        return "main";
    }

    /**
     * 展现首页中的头部页面
     * @return 指定要展现的视图名称
     */
    @RequestMapping("/top.html")
    public String toTop(){
        return "top";
    }

    /**
     * 展现首页中的左侧页面
     * @return 指定要展现的视图名称
     */
    @RequestMapping("/left.html")
    public String toLeft(){
        return "left";
    }

    /**
     * 展现首页中的右侧欢迎页面
     * @return 指定要展现的视图名称
     */
    @RequestMapping("/welcome.html")
    public String toWelcome(){
        return "welcome";
    }

    /**
     * 展现首页中的底部页面
     * @return 指定要展现的视图名称
     */
    @RequestMapping("/footer.html")
    public String toFooter(){
        return "footer";
    }


}
