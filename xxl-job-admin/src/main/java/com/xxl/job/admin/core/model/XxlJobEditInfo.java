package com.xxl.job.admin.core.model;

/**
 * xxl-job edit info
 *
 * @author hangj
 */
public class XxlJobEditInfo {

  private String appname;
  private String executorHandler;
  private String scheduleConf;

  public String getAppname() {
    return appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }

  public String getExecutorHandler() {
    return executorHandler;
  }

  public void setExecutorHandler(String executorHandler) {
    this.executorHandler = executorHandler;
  }

  public String getScheduleConf() {
    return scheduleConf;
  }

  public void setScheduleConf(String scheduleConf) {
    this.scheduleConf = scheduleConf;
  }
}
