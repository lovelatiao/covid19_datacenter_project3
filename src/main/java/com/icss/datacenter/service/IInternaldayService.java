package com.icss.datacenter.service;

import com.icss.datacenter.entity.Internalday;

import java.util.List;

/**
 * 只要是有关时间疫情数据的业务逻辑接口
 */
public interface IInternaldayService {

    /**
     * 获取得到所有满足过滤条件的时间疫情数据列表
     * @param searchInternalday 过滤条件
     * @return 所有满足过滤条件的时间疫情数据列表
     */
    public List<Internalday> findList(Internalday searchInternalday);
}
