/**
 * 
 * @author wenrc@szwgmf.com 2017年3月30日
 *
 */
package com.wenrc.reward.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.wenrc.reward.entity.Role;

/**
 * 
 * @author wenrc@szwgmf.com 2017年3月30日
 *
 */
@SpringBootTest
public class RoleDaoTest extends AbstractTestNGSpringContextTests  {
	
	@Autowired
	private RoleDao roleDao;
	
	//@Test
	public void consumptionListCountTest(){
		Role role=roleDao.selectById(1L);
		//Assert.assertNotNull(role);
	}
	
	@Test
	public void queryByUserIdTest(){
		List<Role> roles=roleDao.queryByUserId(1L);
		for (Role role : roles) {
			//Assert.assertNotNull(role);
		}
	}
	
	@Test
	public void queryByConditionTest(){
		//Assert.assertNotNull(role);
	}
	
	@Test
	public void queryByConditionCountTest(){
		//Assert.assertNotNull(role);
	}
}
