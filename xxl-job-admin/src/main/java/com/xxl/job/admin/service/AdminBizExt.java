package com.xxl.job.admin.service;

import com.xxl.job.admin.core.model.XxlJobEditInfo;
import com.xxl.job.core.biz.model.ReturnT;

/**
 * AdminBiz Ext
 *
 * @author hangj
 */
public interface AdminBizExt {

  ReturnT<String> editJob(XxlJobEditInfo xxlJobEditInfo);
}
