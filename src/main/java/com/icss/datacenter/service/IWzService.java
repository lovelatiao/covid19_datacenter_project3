package com.icss.datacenter.service;

import com.icss.datacenter.entity.Wz;

import java.util.List;

/**
 * @author laohe
 * @company bigdata
 * @create 2022-12-28 9:53
 */
public interface IWzService {
    List<Wz> findByConditions(Wz wzParm);
}
