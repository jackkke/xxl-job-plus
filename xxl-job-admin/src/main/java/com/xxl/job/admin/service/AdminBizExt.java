package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobCreatetInfo;
import com.xxl.job.admin.core.model.XxlJobEditInfo;
import com.xxl.job.admin.core.model.XxlJobTriggerInfo;
import com.xxl.job.core.biz.model.ReturnT;

/**
 * AdminBiz Ext
 *
 * @author hangj
 */
public interface AdminBizExt {

  ReturnT<String> editJob(XxlJobEditInfo xxlJobEditInfo);

  ReturnT<String> createJob(XxlJobCreatetInfo xxlJobCreatetInfo);

  ReturnT<String> triggerJob(XxlJobTriggerInfo xxlJobTriggerInfo);

  ReturnT<String> startJob(int id);

  ReturnT<String> stopJob(int id);
}
