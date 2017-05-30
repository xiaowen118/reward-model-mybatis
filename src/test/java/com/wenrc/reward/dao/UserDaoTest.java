package com.wenrc.reward.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wenrc.reward.bean.user.UserBean;
import com.wenrc.reward.entity.Role;
import com.wenrc.reward.entity.User;
import com.wenrc.reward.entity.UserRole;
import com.wenrc.reward.vo.UserVo;

@SpringBootTest
public class UserDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private UserDao userDao;
	
	//@Test
	public void findByNameTest(){
		User user=userDao.findByName("wenrc");
	}
	
	//@Test
	public void findByEmail(){
		User user=userDao.findByEmail("867316250@qq.com");
		List<Role> roles=user.getRoles();
	}
	
	@Test
	public void queryByConditionTest(){
		UserVo userVo=new UserVo();
		List<UserBean> userbeans=userDao.queryByCondition(userVo);
	}
	
	//@Test
	public void consumptionListCountTest(){
		User user=userDao.selectById(1L);
		Assert.assertNotNull(user);
	}
	
	//@Test
	public void selectLeftJoinByIdTest(){
		User user=userDao.selectLeftJoinById(1L);
		List<UserRole> userRoles=user.getUserRoles();
		//Assert.assertNotNull(user);
	}
	
}
