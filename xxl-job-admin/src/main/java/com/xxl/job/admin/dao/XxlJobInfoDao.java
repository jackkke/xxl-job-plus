package com.xxl.job.admin.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxl.job.admin.core.model.XxlJobInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface XxlJobInfoDao extends IService<XxlJobInfo> {

	List<XxlJobInfo> pageList(@Param("offset") int offset,
									 @Param("pagesize") int pagesize,
									 @Param("jobGroup") int jobGroup,
									 @Param("triggerStatus") int triggerStatus,
									 @Param("jobDesc") String jobDesc,
									 @Param("executorHandler") String executorHandler,
									 @Param("author") String author);
	int pageListCount(@Param("offset") int offset,
							 @Param("pagesize") int pagesize,
							 @Param("jobGroup") int jobGroup,
							 @Param("triggerStatus") int triggerStatus,
							 @Param("jobDesc") String jobDesc,
							 @Param("executorHandler") String executorHandler,
							 @Param("author") String author);

	XxlJobInfo loadById(@Param("id") int id);
	
	int update(XxlJobInfo xxlJobInfo);
	
	int delete(@Param("id") long id);

	List<XxlJobInfo> getJobsByGroup(@Param("jobGroup") int jobGroup);

	int findAllCount();

	List<XxlJobInfo> scheduleJobQuery(@Param("maxNextTime") long maxNextTime, @Param("pagesize") int pagesize );

	int scheduleUpdate(XxlJobInfo xxlJobInfo);


}
