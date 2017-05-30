/**
 * 
 * @author wenrc@szwgmf.com 2017年3月30日
 *
 */
package com.wenrc.reward.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.wenrc.reward.bean.role.RoleBean;
import com.wenrc.reward.entity.Role;
import com.wenrc.reward.vo.RoleVo;

/**
 * 
 * @author wenrc@szwgmf.com 2017年3月30日
 *
 */
@Mapper
public interface RoleDao {
	
	@Select("select * from sys_role where id=#{id} ")
	Role selectById(Long id);
	
	List<Role> queryByUserId(Long userId);
	
	List<RoleBean> queryByCondition(RoleVo roleVo);
	
}
