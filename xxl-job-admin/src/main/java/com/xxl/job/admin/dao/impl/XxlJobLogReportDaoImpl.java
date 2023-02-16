package com.xxl.job.admin.dao.impl;

import com.xxl.job.admin.core.model.XxlJobLogReport;
import com.xxl.job.admin.dao.XxlJobLogReportDao;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class XxlJobLogReportDaoImpl implements XxlJobLogReportDao {

  @Override
  public int save(XxlJobLogReport xxlJobLogReport) {
    return 0;
  }

  @Override
  public int update(XxlJobLogReport xxlJobLogReport) {
    return 0;
  }

  @Override
  public List<XxlJobLogReport> queryLogReport(Date triggerDayFrom, Date triggerDayTo) {
    return null;
  }

  @Override
  public XxlJobLogReport queryLogReportTotal() {
    return null;
  }
}
