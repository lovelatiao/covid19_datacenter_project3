package com.icss.datacenter.service.impl;

import com.icss.datacenter.entity.Province;
import com.icss.datacenter.mapper.ProvinceMapper;
import com.icss.datacenter.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 只要是有关全国各个省份疫情数据信息的业务逻辑接口的实现类
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> findList(Province searchProvince) {
        //从数据库中查询得到所有满足过滤条件的全国各个省份疫情数据信息列表
        return provinceMapper.selectList(searchProvince);
    }

    @Override
    public List<String> findDistinctProvinceInfoList() {
        //从数据库中查询得到所有去重后的省份信息（既包含省份编号，又包含省份名称）列表
        return provinceMapper.selectDistinctProvinceInfoList();
    }

    @Override
    public boolean saveProvince(Province provinceParam) {
        //通过指定的日期和省份名称去数据库中查询省份疫情数据信息
        Province province = provinceMapper.selectByDatetimeAndProvinceShortName(provinceParam.getDatetime(),
                                                            provinceParam.getProvinceShortName());
        //如果没有查询到省份疫情数据信息
        if(province==null){
            //则向数据库中新增指定的省份疫情数据信息记录
            provinceMapper.insertProvince(provinceParam);
            //新增成功，则返回true
            return true;
        }
        //如果查询到省份疫情数据信息，证明该日期下该省份的疫情数据已存在，则新增失败，返回false
        return false;
    }

    @Override
    public Province findByDatetimeAndLocationId(Province provinceParam) {
        //从数据库中通过指定的日期和省份编号查询得到省份疫情数据信息
        return provinceMapper.selectByDatetimeAndLocationId(provinceParam);
    }

    @Override
    public void updateProvince(Province provinceParam) {
        //从数据库中修改指定的省份的疫情数据信息
        provinceMapper.updateProvince(provinceParam);
    }

    @Override
    public void deleteProvince(Province provinceParam) {
        //从数据库中删除指定的省份疫情数据信息
        provinceMapper.deleteByDatetimeAndLocationId(provinceParam);
    }

    @Override
    public void deleteProvinces(String datetime, String locationIds) {
        //从数据库中删除指定的多条省份疫情数据信息
        provinceMapper.deleteByDatetimeAndLocationIds(datetime, locationIds);
    }
}
