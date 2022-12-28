package com.icss.datacenter.service;

import com.icss.datacenter.entity.Province;

import java.util.List;

/**
 * 只要是有关全国各个省份疫情数据信息的业务逻辑接口
 */
public interface IProvinceService {

    /**
     * 获取得到所有满足过滤条件的全国各个省份的疫情数据信息列表
     * @param searchProvince 过滤条件
     * @return 所有满足过滤条件的全国各个省份的疫情数据信息列表
     */
    public List<Province> findList(Province searchProvince);

    /**
     * 获取得到所有的省份信息（既包含省份编号，又包含省份名称）列表
     * @return 得到的所有省份信息（既包含省份编号，又包含省份名称）列表
     */
    public List<String> findDistinctProvinceInfoList();

    /**
     * 实现保存指定省份疫情数据信息的业务逻辑
     * @param provinceParam 指定要保存的省份疫情数据信息
     * @return true代表保存成功，false代表保存失败
     */
    public boolean saveProvince(Province provinceParam);

    /**
     * 通过指定的日期和省份编号获取得到省份疫情数据信息
     * @param provinceParam 指定的日期和省份编号
     * @return 获取得到的省份疫情数据信息
     */
    public Province findByDatetimeAndLocationId(Province provinceParam);

    /**
     * 修改指定的省份疫情数据信息
     * @param provinceParam 修改后的省份疫情数据信息
     */
    public void updateProvince(Province provinceParam);

    /**
     * 删除指定的省份疫情数据信息
     * @param provinceParam 指定要删除的省份疫情数据信息
     */
    public void deleteProvince(Province provinceParam);

    /**
     * 实现删除指定多条省份疫情数据信息的业务逻辑
     * @param datetime 指定的日期
     * @param locationIds 指定的多条省份编号
     */
    public void deleteProvinces(String datetime,String locationIds);



}
