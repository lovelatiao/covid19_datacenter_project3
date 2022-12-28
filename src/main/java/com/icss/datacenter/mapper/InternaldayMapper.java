package com.icss.datacenter.mapper;

import com.icss.datacenter.entity.Internalday;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 只要是有关时间疫情数据的数据操作
 */
@Repository
public interface InternaldayMapper {

    /**
     * 从数据库中查询得到所有满足过滤条件的时间疫情数据列表
     * @param searchInternalday 过滤条件
     * @return 查询到的所有满足过滤条件的时间疫情数据列表
     */

    public List<Internalday> selectList(Internalday searchInternalday);

}
