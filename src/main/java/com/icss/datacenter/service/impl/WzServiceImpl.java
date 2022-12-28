package com.icss.datacenter.service.impl;

import com.icss.datacenter.entity.Wz;
import com.icss.datacenter.mapper.WzMapper;
import com.icss.datacenter.service.IWzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author laohe
 * @company bigdata
 * @create 2022-12-28 9:54
 */
@Service
@Transactional
public class WzServiceImpl implements IWzService {
    @Autowired
    private WzMapper wzMapper;
    @Override
    public List<Wz> findByConditions(Wz wzParm) {
        return wzMapper.selectByContions(wzParm);
    }
}
