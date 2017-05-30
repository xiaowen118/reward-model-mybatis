package com.wenrc.reward.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wenrc.reward.bean.user.UserBean;
import com.wenrc.reward.entity.User;
import com.wenrc.reward.vo.UserVo;

@Mapper
public interface UserDao {
	int insert(User user);

	User selectOneByCondition(User user);

	User selectById(Long id);

	int updateById(User user);

	int deleteById(Integer id);

	List<User> queryAll();

	@Select("select a.*,b.role_id roleId from sys_user a LEFT JOIN sys_user_role b on a.id=b.user_id where a.id=#{id} ")
	@Results({
			@Result(property = "userRoles", column = "id", many = @Many(select = "com.wenrc.reward.dao.UserRoleDao.findByUserId")) })
	User selectLeftJoinById(Long id);

	User findByName(String userName);

	@Select("SELECT *,id userId FROM sys_user WHERE 1=1 AND email=#{email}")
	@Results({@Result(property = "roles", column = "userId", 
			many = @Many(select = "com.wenrc.reward.dao.RoleDao.queryByUserId")) })
	User findByEmail(String email);
	
	List<UserBean> queryByCondition(UserVo userVo);
	
}
