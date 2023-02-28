package com.xxl.job.admin.core.model;

/**
 * xxl-job edit info
 *
 * @author hangj
 */
public class XxlJobCreatetInfo {
  
  private Integer jobGroup;
  private String appname;
  private String jobDesc;
  private String author;		// 负责人
  private String alarmEmail;	// 报警邮件
  private String scheduleType;			// 调度类型
  private String scheduleConf;			// 调度配置，值含义取决于调度类型
  private String schedule_conf_CRON;
  private String schedule_conf_FIX_RATE;
  private String schedule_conf_FIX_DELAY;
  private String misfireStrategy;			// 调度过期策略
  private String executorRouteStrategy;	// 执行器路由策略
  private String executorHandler;		    // 执行器，任务Handler名称
  private String executorParam;		    // 执行器，任务参数
  private String executorBlockStrategy;	// 阻塞处理策略
  private int executorTimeout;     		// 任务执行超时时间，单位秒
  private int executorFailRetryCount;		// 失败重试次数
  private String glueType;		// GLUE类型	#com.xxl.job.core.glue.GlueTypeEnum
  private String glueSource;		// GLUE源代码
  private String glueRemark;		// GLUE备注
  private String childJobId;		// 子任务ID，多个逗号分隔
  private int triggerStatus;		// 调度状态：0-停止，1-运行

  public Integer getJobGroup() {
    return jobGroup;
  }

  public void setJobGroup(Integer jobGroup) {
    this.jobGroup = jobGroup;
  }

  public String getAppname() {
    return appname;
  }

  public void setAppname(String appname) {
    this.appname = appname;
  }

  public String getJobDesc() {
    return jobDesc;
  }

  public void setJobDesc(String jobDesc) {
    this.jobDesc = jobDesc;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAlarmEmail() {
    return alarmEmail;
  }

  public void setAlarmEmail(String alarmEmail) {
    this.alarmEmail = alarmEmail;
  }

  public String getScheduleType() {
    return scheduleType;
  }

  public void setScheduleType(String scheduleType) {
    this.scheduleType = scheduleType;
  }

  public String getScheduleConf() {
    return scheduleConf;
  }

  public void setScheduleConf(String scheduleConf) {
    this.scheduleConf = scheduleConf;
  }

  public String getSchedule_conf_CRON() {
    return schedule_conf_CRON;
  }

  public void setSchedule_conf_CRON(String schedule_conf_CRON) {
    this.schedule_conf_CRON = schedule_conf_CRON;
  }

  public String getSchedule_conf_FIX_RATE() {
    return schedule_conf_FIX_RATE;
  }

  public void setSchedule_conf_FIX_RATE(String schedule_conf_FIX_RATE) {
    this.schedule_conf_FIX_RATE = schedule_conf_FIX_RATE;
  }

  public String getSchedule_conf_FIX_DELAY() {
    return schedule_conf_FIX_DELAY;
  }

  public void setSchedule_conf_FIX_DELAY(String schedule_conf_FIX_DELAY) {
    this.schedule_conf_FIX_DELAY = schedule_conf_FIX_DELAY;
  }

  public String getMisfireStrategy() {
    return misfireStrategy;
  }

  public void setMisfireStrategy(String misfireStrategy) {
    this.misfireStrategy = misfireStrategy;
  }

  public String getExecutorRouteStrategy() {
    return executorRouteStrategy;
  }

  public void setExecutorRouteStrategy(String executorRouteStrategy) {
    this.executorRouteStrategy = executorRouteStrategy;
  }

  public String getExecutorHandler() {
    return executorHandler;
  }

  public void setExecutorHandler(String executorHandler) {
    this.executorHandler = executorHandler;
  }

  public String getExecutorParam() {
    return executorParam;
  }

  public void setExecutorParam(String executorParam) {
    this.executorParam = executorParam;
  }

  public String getExecutorBlockStrategy() {
    return executorBlockStrategy;
  }

  public void setExecutorBlockStrategy(String executorBlockStrategy) {
    this.executorBlockStrategy = executorBlockStrategy;
  }

  public int getExecutorTimeout() {
    return executorTimeout;
  }

  public void setExecutorTimeout(int executorTimeout) {
    this.executorTimeout = executorTimeout;
  }

  public int getExecutorFailRetryCount() {
    return executorFailRetryCount;
  }

  public void setExecutorFailRetryCount(int executorFailRetryCount) {
    this.executorFailRetryCount = executorFailRetryCount;
  }

  public String getGlueType() {
    return glueType;
  }

  public void setGlueType(String glueType) {
    this.glueType = glueType;
  }

  public String getGlueSource() {
    return glueSource;
  }

  public void setGlueSource(String glueSource) {
    this.glueSource = glueSource;
  }

  public String getGlueRemark() {
    return glueRemark;
  }

  public void setGlueRemark(String glueRemark) {
    this.glueRemark = glueRemark;
  }

  public String getChildJobId() {
    return childJobId;
  }

  public void setChildJobId(String childJobId) {
    this.childJobId = childJobId;
  }

  public int getTriggerStatus() {
    return triggerStatus;
  }

  public void setTriggerStatus(int triggerStatus) {
    this.triggerStatus = triggerStatus;
  }
}
