package com.wenrc.reward.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.wenrc.reward.entity.UserRole;

/**
 * 
 * @author wenrc@szwgmf.com 2017年3月29日
 *
 */
@Mapper
public interface UserRoleDao {

	/**
	 * 
	 * @author wenrc@szwgmf.com 2017年3月29日
	 *
	 */
	@Select("select userId,roleId roleId from sys_user_role where roleId=#{roleId} ")
	/*
	 * @Results({
	 * 
	 * @Result(property="courses", column="tutor_id", many= @Many(select=
	 * "com.owen.mybatis.mappers.TutorMapper.findCoursesByTutorId")) })
	 */
	// @Result(property="user",column="user_id",javaType=User.class,one=@One(select="com.wenrc.reward.dao.UserDao.selectById"))
	// @Result(property="user",column="user_id",javaType=User.class,one=@One(select="selectOrg",
	// mapper=UserDao.class))
	// @Many(select="com.wzkj.manage.mapper.RoutePointMapper.getByRoute")

	@Results({
			// @Result(column="userId", property="userId"),
			// @Result(column="roleId", property="roleId"),
			@Result(property = "user", column = "user_id", one = @One(select = "com.wenrc.reward.dao.UserDao.selectById")) })
	UserRole findUserByRoleId(Long roleId);

	@Select("select userId userId,roleId roleId from sys_user_role where userId=#{userId}")
	/*
	 * @Results({
	 * 
	 * @Result(property="role", column="roleId",
	 * one=@One(select="com.wenrc.reward.dao.RoleDao.selectById")) })
	 */
	List<UserRole> findByUserId(Long userId);
}
