package com.wenrc.reward.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * 
 * @author wenrc@szwgmf.com 2017年3月31日
 *
 */
@SpringBootTest
public class ResourceDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private ResourceDao resourceDao;

	// @Autowired
	// private SqlSession sqlSession;

	@Autowired
	SqlSessionFactory sqlSessionFactory;
	

	/*
	 * @Test public void queryByUserIdTest(){ List<Resource>
	 * resources=resourceDao.queryByUserId(1L);
	 * 
	 * for (Resource resource : resources) {
	 * System.out.println("-----------------------------"+resource.getName()); }
	 * }
	 * 
	 * @Test public void queryByConditionTest(){ //Assert.assertNotNull(role); }
	 * 
	 * @Test public void queryByConditionCountTest(){
	 * //Assert.assertNotNull(role); }
	 */

}
