package com.icss.datacenter.service.impl;

import com.icss.datacenter.entity.Internalday;
import com.icss.datacenter.mapper.InternaldayMapper;
import com.icss.datacenter.service.IInternaldayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 只要是有关时间疫情数据的业务逻辑接口的实现类
 */
@Service
public class InternaldayServiceImpl implements IInternaldayService {

    @Autowired
    private InternaldayMapper internaldayMapper;

    @Override
    public List<Internalday> findList(Internalday searchInternalday) {
        //从数据库中查询得到所有满足过滤条件的时间疫情数据列表
        return internaldayMapper.selectList(searchInternalday);
    }

}
