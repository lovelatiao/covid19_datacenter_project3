package com.icss.datacenter.mapper;

import com.icss.datacenter.entity.Wz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author laohe
 * @company bigdata
 * @create 2022-12-28 9:54
 */
@Mapper
@Repository
public interface WzMapper {
    @Select("<script>"+"select * from t_covid19_wz where 1=1 "+
    "<if test='name!=null'> and name like concat('%',#{name},'%')</if>" + "</script>")
    List<Wz> selectByContions(Wz wzParm);
}
