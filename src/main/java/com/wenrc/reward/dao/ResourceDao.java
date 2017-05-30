package com.wenrc.reward.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wenrc.reward.bean.resource.ResourceBean;
import com.wenrc.reward.entity.Resource;
import com.wenrc.reward.vo.ResourceVo;

/**
 * 
 * @author wenrc@szwgmf.com 2017年3月31日
 *
 */
@Mapper
public interface ResourceDao {
	
	List<Resource> queryByUserId(Long userId);

	List<Resource> queryMenueByUserId(Long userId);

	List<ResourceBean> queryByCondition(ResourceVo resourceVo);
	
}
