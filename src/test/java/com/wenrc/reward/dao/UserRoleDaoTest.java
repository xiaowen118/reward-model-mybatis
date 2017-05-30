package com.wenrc.reward.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.wenrc.reward.entity.UserRole;

/**
 * 
 * @author wenrc@szwgmf.com 2017年3月29日
 *
 */
@SpringBootTest
public class UserRoleDaoTest extends AbstractTestNGSpringContextTests  {
	@Autowired
	private UserRoleDao userRoleDao;
	
	//@Test
	public void findUserByRoleIdTest(){
		if (userRoleDao==null) {
		}
		UserRole userRole=userRoleDao.findUserByRoleId(2L);
		//Assert.assertNotNull(user);
	}
	
	
	@Test
	public void findByUserIdTest(){
		List<UserRole> userRoles=userRoleDao.findByUserId(1L);
		for (UserRole userRole : userRoles) {
		}
	}
}
