package com.xxl.job.admin.dao.impl;

import com.xxl.job.admin.core.model.XxlJobLog;
import com.xxl.job.admin.dao.XxlJobLogDao;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class XxlJobLogDaoImpl implements XxlJobLogDao {

  @Override
  public List<XxlJobLog> pageList(int offset, int pagesize, int jobGroup, int jobId, Date triggerTimeStart, Date triggerTimeEnd, int logStatus) {
    return null;
  }

  @Override
  public int pageListCount(int offset, int pagesize, int jobGroup, int jobId, Date triggerTimeStart, Date triggerTimeEnd, int logStatus) {
    return 0;
  }

  @Override
  public XxlJobLog load(long id) {
    return null;
  }

  @Override
  public long save(XxlJobLog xxlJobLog) {
    return 0;
  }

  @Override
  public int updateTriggerInfo(XxlJobLog xxlJobLog) {
    return 0;
  }

  @Override
  public int updateHandleInfo(XxlJobLog xxlJobLog) {
    return 0;
  }

  @Override
  public int delete(int jobId) {
    return 0;
  }

  @Override
  public Map<String, Object> findLogReport(Date from, Date to) {
    return null;
  }

  @Override
  public List<Long> findClearLogIds(int jobGroup, int jobId, Date clearBeforeTime, int clearBeforeNum, int pagesize) {
    return null;
  }

  @Override
  public int clearLog(List<Long> logIds) {
    return 0;
  }

  @Override
  public List<Long> findFailJobLogIds(int pagesize) {
    return null;
  }

  @Override
  public int updateAlarmStatus(long logId, int oldAlarmStatus, int newAlarmStatus) {
    return 0;
  }

  @Override
  public List<Long> findLostJobIds(Date losedTime) {
    return null;
  }
}
