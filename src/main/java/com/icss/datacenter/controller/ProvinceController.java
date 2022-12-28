package com.icss.datacenter.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.datacenter.entity.Province;
import com.icss.datacenter.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 只要是有关全国各个省份疫情数据的处理器
 */
@Controller
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    /**
     * 分页展现全国各个省份的疫情数据信息
     * @param searchProvince 过滤条件
     * @param currentPage 展现的页码
     * @return
     */
    @RequestMapping("/provinceList")
    public ModelAndView toList(Province searchProvince, Integer currentPage){
        ModelAndView modelAndView = new ModelAndView("province/provinceList");
        //对分页的条件进行处理
        if(currentPage==null){
            currentPage = 1;
        }
        Integer pageSize = 3;
        PageHelper.startPage(currentPage,pageSize);
        //对搜索条件进行处理
        if(searchProvince.getDatetime()==null || "".equals(searchProvince.getDatetime())){
            //如果没有传递根据某个指定的日期进行过滤查询，则默认展现系统最新日期下个相关数据
            Date date = new Date();
            //把Date类型的日期转换成yyyy-MM-dd这种格式的字符串类型
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //String dateStr = simpleDateFormat.format(date);
            //为了测试方便，写死一个日期模拟当前的最新时间
            String dateStr = "2021-12-24";
            searchProvince.setDatetime(dateStr);
        }
        //需要有一个能够帮助我们实现获取得到所有满足过滤条件的省份疫情数据信息列表的业务逻辑
        List<Province> provinceList = provinceService.findList(searchProvince);
        //封装得到分页结果
        PageInfo<Province> pageInfo = new PageInfo<>(provinceList);
        //将分页结果传递到页面资源上去
        modelAndView.addObject("pageInfo",pageInfo);
        //将过滤条件传递到页面资源上去
        modelAndView.addObject("searchProvince",searchProvince);
        //由于页面上需要展现省份信息列表的下拉框
        //需要获取得到所有的省份信息（省份名称）列表
        List<String> provinceInfoList = provinceService.findDistinctProvinceInfoList();
        //将得到的省份信息列表传递到页面资源上去
        modelAndView.addObject("provinceInfoList",provinceInfoList);
        return modelAndView;
    }

    /**
     * 展现添加省份疫情数据信息的页面
     * @return
     */
    @RequestMapping("/addProvince.html")
    public ModelAndView toAddProvince(){
        ModelAndView modelAndView = new ModelAndView("province/addProvince");
        //需要获取得到所有的省份信息（省份信息既包含省份编号，又包含省份名称）列表
        List<String> provinceInfoList = provinceService.findDistinctProvinceInfoList();
        //将得到的省份信息列表传递到页面资源上去
        modelAndView.addObject("provinceInfoList",provinceInfoList);
        return modelAndView;
    }

    /**
     * 保存省份疫情数据信息
     * @param provinceParam 要保存的省份疫情数据信息
     * @param model 用于数据的传递
     * @return
     */
    @RequestMapping("/saveProvince")
    public String toSaveProvince(Province provinceParam, Model model){
        //对要保存的疫情数据信息进行处理
        String provinceInfo = provinceParam.getProvinceInfo();
        String[] provinceInfoArray = provinceInfo.split(",");
        provinceParam.setLocationId(Integer.parseInt(provinceInfoArray[0]));
        provinceParam.setProvinceShortName(provinceInfoArray[1]);
        //需要有一个能够帮助我们实现保存指定省份疫情数据信息的业务逻辑
        boolean flag = provinceService.saveProvince(provinceParam);
        //根据得到的不同的返回值，给出用户不同的响应
        if(flag){ //如果走进该if判断中，证明flag的值为true
            //跳转到展现省份疫情数据信息的列表页面上去
            return "forward:/provinceList";
        }else{ //证明flag的值为false
            //传递一个错误提示
            model.addAttribute("msg","该日期下的省份已存在疫情数据");
            //跳转到添加省份疫情数据信息的页面上去
            return "forward:/addProvince.html";
        }
    }

    /**
     * 展现修改指定省份的疫情数据信息页面
     * @param provinceParam 指定的省份疫情数据（指定的日期和指定的省份编号）
     * @return
     */
    @RequestMapping("/updateProvince.html")
    public ModelAndView toUpdateProvince(Province provinceParam){
        ModelAndView modelAndView = new ModelAndView("province/updateProvince");
        //获取得到指定的省份疫情数据信息，即通过指定的日期和省份编号获取得到省份疫情数据信息
        Province province = provinceService.findByDatetimeAndLocationId(provinceParam);
        //将得到的省份疫情数据信息传递到下一个资源上去
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    /**
     * 修改指定省份的疫情数据信息
     * @param provinceParam 修改后的省份疫情数据信息
     * @return
     */
    @RequestMapping("/updateProvince")
    public String updateProvince(Province provinceParam){
        //需要有一个能够帮助我们实现修改指定省份的疫情数据信息的业务逻辑
        provinceService.updateProvince(provinceParam);
        return "forward:/provinceList";
    }

    /**
     * 展现指定省份的疫情数据信息详情页面
     * @param provinceParam 指定的省份疫情数据（指定的日期和指定的省份编号）
     * @return
     */
    @RequestMapping("/detailProvince.html")
    public ModelAndView toDetailProvince(Province provinceParam){
        ModelAndView modelAndView = new ModelAndView("province/detailProvince");
        //获取得到指定的省份疫情数据信息，即通过指定的日期和省份编号获取得到省份疫情数据信息
        Province province = provinceService.findByDatetimeAndLocationId(provinceParam);
        //将得到的省份疫情数据信息传递到下一个资源上去
        modelAndView.addObject("province",province);
        return modelAndView;
    }

    /**
     * 删除指定的省份疫情数据信息
     * @param provinceParam 指定要删除的省份疫情数据信息（指定的日期和指定的省份编号）
     * @return
     */
    @RequestMapping("/deleteProvince")
    public String toDeleteProvince(Province provinceParam){
        //需要有一个能够帮助我们实现删除指定省份疫情数据信息的业务逻辑
        provinceService.deleteProvince(provinceParam);
        return "forward:/provinceList";
    }

    /**
     * 批量删除多条指定省份疫情数据信息
     * @param datetime 指定的日期
     * @param locationIds 指定的多条省份编号
     * @return
     */
    @RequestMapping("/deleteProvinces")
    public String toDeleteProvinces(String datetime,String locationIds){
        //需要有一个能够帮助我们实现删除指定多条省份疫情数据信息的业务逻辑
        provinceService.deleteProvinces(datetime, locationIds);
        return "forward:/provinceList";
    }




}
