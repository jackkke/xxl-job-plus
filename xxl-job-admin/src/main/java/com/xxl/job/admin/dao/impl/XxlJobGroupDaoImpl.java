package com.xxl.job.admin.dao.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.job.admin.core.model.XxlJobGroup;
import com.xxl.job.admin.dao.XxlJobGroupDao;
import com.xxl.job.admin.mapper.XxlJobGroupMapper;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class XxlJobGroupDaoImpl extends ServiceImpl<XxlJobGroupMapper, XxlJobGroup> implements XxlJobGroupDao {

  @Override
  public List<XxlJobGroup> findAll() {
    LambdaQueryChainWrapper<XxlJobGroup> lambdaQueryChain = this.lambdaQuery()
        .orderByAsc(XxlJobGroup::getAppname)
        .orderByAsc(XxlJobGroup::getTitle)
        .orderByAsc(XxlJobGroup::getId);
    return lambdaQueryChain.list();
  }

  @Override
  public List<XxlJobGroup> findByAddressType(int addressType) {
    LambdaQueryChainWrapper<XxlJobGroup> lambdaQueryChain = this.lambdaQuery()
        .eq(XxlJobGroup::getAddressType, addressType)
        .orderByAsc(XxlJobGroup::getAppname)
        .orderByAsc(XxlJobGroup::getTitle)
        .orderByAsc(XxlJobGroup::getId);
    return lambdaQueryChain.list();
  }

  @Override
  public int update(XxlJobGroup xxlJobGroup) {
    return baseMapper.updateById(xxlJobGroup);
  }

  @Override
  public int remove(int id) {
    return baseMapper.deleteById(id);
  }

  @Override
  public XxlJobGroup load(int id) {
    return baseMapper.selectById(id);
  }

  @Override
  public Page<XxlJobGroup> pageList(int offset, int pagesize, String appname, String title) {
    LambdaQueryChainWrapper<XxlJobGroup> lambdaQueryChain = this.lambdaQuery()
        .like(Objects.nonNull(appname), XxlJobGroup::getAppname, appname)
        .like(Objects.nonNull(title), XxlJobGroup::getTitle, title)
        .orderByAsc(XxlJobGroup::getAppname)
        .orderByAsc(XxlJobGroup::getTitle)
        .orderByAsc(XxlJobGroup::getId);
    return baseMapper.selectPage(Page.of(offset, pagesize), lambdaQueryChain);
  }
}
