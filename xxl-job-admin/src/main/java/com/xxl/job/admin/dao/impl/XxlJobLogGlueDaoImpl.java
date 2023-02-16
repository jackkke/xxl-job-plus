package com.xxl.job.admin.dao.impl;

import com.xxl.job.admin.core.model.XxlJobLogGlue;
import com.xxl.job.admin.dao.XxlJobLogGlueDao;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class XxlJobLogGlueDaoImpl implements XxlJobLogGlueDao {

  @Override
  public int save(XxlJobLogGlue xxlJobLogGlue) {
    return 0;
  }

  @Override
  public List<XxlJobLogGlue> findByJobId(int jobId) {
    return null;
  }

  @Override
  public int removeOld(int jobId, int limit) {
    return 0;
  }

  @Override
  public int deleteByJobId(int jobId) {
    return 0;
  }
}
