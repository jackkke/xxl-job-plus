package com.xxl.job.admin.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.dao.XxlJobInfoDao;
import com.xxl.job.admin.mapper.XxlJobInfoMapper;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class XxlJobInfoDaoImpl extends ServiceImpl<XxlJobInfoMapper, XxlJobInfo> implements XxlJobInfoDao {

  @Override
  public List<XxlJobInfo> pageList(int offset, int pagesize, int jobGroup, int triggerStatus, String jobDesc, String executorHandler, String author) {
    return null;
  }

  @Override
  public int pageListCount(int offset, int pagesize, int jobGroup, int triggerStatus, String jobDesc, String executorHandler, String author) {
    return 0;
  }

  @Override
  public boolean save(XxlJobInfo info) {
    return false;
  }

  @Override
  public XxlJobInfo loadById(int id) {
    return null;
  }

  @Override
  public int update(XxlJobInfo xxlJobInfo) {
    return 0;
  }

  @Override
  public int delete(long id) {
    return 0;
  }

  @Override
  public List<XxlJobInfo> getJobsByGroup(int jobGroup) {
    return null;
  }

  @Override
  public int findAllCount() {
    return 0;
  }

  @Override
  public List<XxlJobInfo> scheduleJobQuery(long maxNextTime, int pagesize) {
    return null;
  }

  @Override
  public int scheduleUpdate(XxlJobInfo xxlJobInfo) {
    return 0;
  }
}
