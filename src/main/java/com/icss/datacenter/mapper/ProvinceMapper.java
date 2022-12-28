package com.icss.datacenter.mapper;

import com.icss.datacenter.entity.Province;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 只要是有关全国各个省份疫情数据信息的数据操作
 */
@Repository
public interface ProvinceMapper {

    /**
     * 从数据库中查询得到所有满足过滤条件的全国各个省份疫情数据信息列表
     * @param searchProvince 过滤条件
     * @return 查询得到的所有满足过滤条件的全国各个省份疫情数据信息列表
     */
    public List<Province> selectList(Province searchProvince);

    /**
     * 从数据库中查询得到所有去重后的省份信息（既包含省份编号，又包含省份名称）列表
     * @return 查询得到的所有重后的省份信息（既包含省份编号，又包含省份名称）列表
     */
    public List<String> selectDistinctProvinceInfoList();

    /**
     * 通过指定的日期和省份名称去数据库中查询省份疫情数据信息
     * @param datetime 指定的日期
     * @param provinceShortName 指定的省份名称
     * @return 查询到的省份疫情数据信息
     */
    public Province selectByDatetimeAndProvinceShortName(@Param("datetime") String datetime,
                                                         @Param("provinceShortName") String provinceShortName);


    /**
     * 向数据库中新增指定的省份疫情数据信息记录
     * @param provinceParam 指定要新增的省份疫情数据信息记录
     */
    public void insertProvince(Province provinceParam);

    /**
     * 从数据库中通过指定的日期和省份编号查询得到省份疫情数据信息
     * @param provinceParam 指定的日期和省份编号
     * @return 查询得到的省份疫情数据信息
     */
    public Province selectByDatetimeAndLocationId(Province provinceParam);

    /**
     * 从数据库中修改指定的省份的疫情数据信息
     * @param provinceParam 修改后的省份疫情数据信息
     */
    public void updateProvince(Province provinceParam);

    /**
     * 从数据库中删除指定的省份疫情数据信息
     * @param provinceParam 指定要删除的省份疫情数据信息
     */
    public void deleteByDatetimeAndLocationId(Province provinceParam);

    /**
     * 从数据库中删除指定的多条省份疫情数据信息
     * @param datetime 指定的日期
     * @param locationIds 指定的多条省份编号
     */
    public void deleteByDatetimeAndLocationIds(@Param("datetime") String datetime,
                                               @Param("locationIds") String locationIds);
}
