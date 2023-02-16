package com.xxl.job.admin.dao.impl;

import com.xxl.job.admin.core.model.XxlJobRegistry;
import com.xxl.job.admin.dao.XxlJobRegistryDao;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class XxlJobRegistryDaoImpl implements XxlJobRegistryDao {

  @Override
  public List<Integer> findDead(int timeout, Date nowTime) {
    return null;
  }

  @Override
  public int removeDead(List<Integer> ids) {
    return 0;
  }

  @Override
  public List<XxlJobRegistry> findAll(int timeout, Date nowTime) {
    return null;
  }

  @Override
  public int registryUpdate(String registryGroup, String registryKey, String registryValue, Date updateTime) {
    return 0;
  }

  @Override
  public int registrySave(String registryGroup, String registryKey, String registryValue, Date updateTime) {
    return 0;
  }

  @Override
  public int registryDelete(String registryGroup, String registryKey, String registryValue) {
    return 0;
  }
}
