package com.xxl.job.admin.dao.impl;

import com.xxl.job.admin.core.model.XxlJobUser;
import com.xxl.job.admin.dao.XxlJobUserDao;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class XxlJobUserDaoImpl implements XxlJobUserDao {

  @Override
  public List<XxlJobUser> pageList(int offset, int pagesize, String username, int role) {
    return null;
  }

  @Override
  public int pageListCount(int offset, int pagesize, String username, int role) {
    return 0;
  }

  @Override
  public XxlJobUser loadByUserName(String username) {
    return null;
  }

  @Override
  public int save(XxlJobUser xxlJobUser) {
    return 0;
  }

  @Override
  public int update(XxlJobUser xxlJobUser) {
    return 0;
  }

  @Override
  public int delete(int id) {
    return 0;
  }
}
