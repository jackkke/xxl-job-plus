package com.xxl.job.admin.service.impl;

import com.xxl.job.admin.core.cron.CronExpression;
import com.xxl.job.admin.core.model.XxlJobCreatetInfo;
import com.xxl.job.admin.core.model.XxlJobEditInfo;
import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.scheduler.ScheduleTypeEnum;
import com.xxl.job.admin.core.thread.JobScheduleHelper;
import com.xxl.job.admin.core.util.I18nUtil;
import com.xxl.job.admin.dao.XxlJobGroupDao;
import com.xxl.job.admin.dao.XxlJobInfoDao;
import com.xxl.job.admin.service.AdminBizExt;
import com.xxl.job.admin.service.XxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * AdminBiz Ext Impl
 *
 * @author hangj
 */
@Service
public class AdminBizExtImpl implements AdminBizExt {

  private static final Logger logger = LoggerFactory.getLogger(AdminBizExtImpl.class);
  @Resource
  private XxlJobInfoDao xxlJobInfoDao;
  @Resource
  private XxlJobGroupDao xxlJobGroupDao;
  @Resource
  private XxlJobService xxlJobService;
  

  @Override
  public ReturnT<String> editJob(XxlJobEditInfo xxlJobEditInfo) {
    XxlJobInfo exists_jobInfo = null;
    try {
      assert xxlJobEditInfo != null;
      assert xxlJobEditInfo.getAppname() != null;
      assert xxlJobEditInfo.getExecutorHandler() != null;
      assert xxlJobEditInfo.getScheduleConf() != null;

      List<XxlJobGroup> xxlJobGroups = xxlJobGroupDao.pageList(0, 10, xxlJobEditInfo.getAppname(), null);
      if (!CollectionUtils.isEmpty(xxlJobGroups) && xxlJobGroups.size() == 1) {
        List<XxlJobInfo> xxlJobInfos = xxlJobInfoDao.getJobsByGroup(xxlJobGroups.get(0).getId());
        if (!CollectionUtils.isEmpty(xxlJobInfos)) {
          List<XxlJobInfo> collect = xxlJobInfos.stream()
              .filter(o -> Objects.equals(o.getExecutorHandler(), xxlJobEditInfo.getExecutorHandler()))
              .collect(Collectors.toList());
          if (!CollectionUtils.isEmpty(collect) && collect.size() == 1) {
            exists_jobInfo = collect.get(0);
          } else {
            throw new RuntimeException("job is not find or find over 1");
          }
        } else {
          throw new RuntimeException("job is not find");
        }
      } else {
        throw new RuntimeException("group is not find or find over 1");
      }
    } catch (Exception e) {
      return new ReturnT<>(ReturnT.FAIL_CODE, e.getMessage());
    }

    // valid trigger
    ScheduleTypeEnum scheduleTypeEnum = ScheduleTypeEnum.match(exists_jobInfo.getScheduleType(), null);
    if (scheduleTypeEnum == null) {
      return new ReturnT<>(ReturnT.FAIL_CODE, (I18nUtil.getString("schedule_type") + I18nUtil.getString("system_unvalid")));
    }
    if (scheduleTypeEnum == ScheduleTypeEnum.CRON) {
      if (exists_jobInfo.getScheduleConf() == null || !CronExpression.isValidExpression(exists_jobInfo.getScheduleConf())) {
        return new ReturnT<>(ReturnT.FAIL_CODE, "Cron" + I18nUtil.getString("system_unvalid"));
      }
    } else if (scheduleTypeEnum == ScheduleTypeEnum.FIX_RATE /*|| scheduleTypeEnum == ScheduleTypeEnum.FIX_DELAY*/) {
      if (exists_jobInfo.getScheduleConf() == null) {
        return new ReturnT<>(ReturnT.FAIL_CODE, (I18nUtil.getString("schedule_type") + I18nUtil.getString("system_unvalid")));
      }
      try {
        int fixSecond = Integer.parseInt(exists_jobInfo.getScheduleConf());
        if (fixSecond < 1) {
          return new ReturnT<>(ReturnT.FAIL_CODE, (I18nUtil.getString("schedule_type") + I18nUtil.getString("system_unvalid")));
        }
      } catch (Exception e) {
        return new ReturnT<>(ReturnT.FAIL_CODE, (I18nUtil.getString("schedule_type") + I18nUtil.getString("system_unvalid")));
      }
    }

    // next trigger time (5s后生效，避开预读周期)
    long nextTriggerTime = exists_jobInfo.getTriggerNextTime();
    boolean scheduleDataNotChanged = exists_jobInfo.getScheduleConf().equals(xxlJobEditInfo.getScheduleConf());
    if (exists_jobInfo.getTriggerStatus() == 1 && !scheduleDataNotChanged) {
      try {
        Date nextValidTime = JobScheduleHelper.generateNextValidTime(exists_jobInfo,
            new Date(System.currentTimeMillis() + JobScheduleHelper.PRE_READ_MS));
        if (nextValidTime == null) {
          return new ReturnT<>(ReturnT.FAIL_CODE, (I18nUtil.getString("schedule_type") + I18nUtil.getString("system_unvalid")));
        }
        nextTriggerTime = nextValidTime.getTime();
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        return new ReturnT<>(ReturnT.FAIL_CODE, (I18nUtil.getString("schedule_type") + I18nUtil.getString("system_unvalid")));
      }
    }

    exists_jobInfo.setScheduleConf(xxlJobEditInfo.getScheduleConf());
    exists_jobInfo.setTriggerNextTime(nextTriggerTime);
    xxlJobInfoDao.update(exists_jobInfo);
    return ReturnT.SUCCESS;
  }

  @Override
  public ReturnT<String> createJob(XxlJobCreatetInfo xxlJobCreatetInfo) {
    XxlJobInfo xxlJobInfo = new XxlJobInfo();
    try {
      assert xxlJobCreatetInfo != null;
      assert xxlJobCreatetInfo.getAppname() != null;

      BeanUtils.copyProperties(xxlJobCreatetInfo, xxlJobInfo);
      if (xxlJobCreatetInfo.getJobGroup() == null) {
        List<XxlJobGroup> xxlJobGroups = xxlJobGroupDao.pageList(0, 10, xxlJobCreatetInfo.getAppname(), null);
        if (!CollectionUtils.isEmpty(xxlJobGroups) && xxlJobGroups.size() == 1) {
          xxlJobInfo.setJobGroup(xxlJobGroups.get(0).getId());
        } else {
          throw new RuntimeException("group is not find or find over 1");
        }
      }
      return xxlJobService.add(xxlJobInfo);
    } catch (Exception e) {
      return new ReturnT<>(ReturnT.FAIL_CODE, e.getMessage());
    }
  }
}
