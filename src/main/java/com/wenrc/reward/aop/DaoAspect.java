package com.wenrc.reward.aop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.wenrc.reward.pagination.Pagination;
import com.wenrc.reward.sql.DatabaseEnum;
import com.wenrc.reward.sql.MySqlSqlAssistant;
import com.wenrc.reward.sql.OracleSqlAssistant;
import com.wenrc.reward.sql.SqlAssistant;
import com.wenrc.reward.sql.SqlFormat;

/**
 * 
 * @author wen_rc@sina.com 2017年5月15日
 *
 */

@Component
@Aspect
public class DaoAspect {
	
	private static Logger logger = Logger.getLogger(DaoAspect.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private static String DATABASE_NAME = "";

	@Before(value = "execution(* com.wenrc.reward.dao.*.*(..))")
	public void before(JoinPoint call) {
		
		long start = System.currentTimeMillis();

		MethodSignature methodSignature = (MethodSignature) call.getSignature();
		// 返回值类型
		Class<?> returnType = methodSignature.getReturnType();

		// 判断是否是集合类型,如果不是集合类型，不需要计算count
		if (!Collection.class.isAssignableFrom(returnType)) {
			return;
		}

		// 被代理对象类型
		Class<?> targetClass = methodSignature.getMethod().getDeclaringClass();
		// 被代理对象目标方法
		String methodName = call.getSignature().getName();
		// 目标sql id
		String statementSqlId = targetClass.getName() + "." + methodName;
		// 被代理对象目标方法参数
		Object[] args = call.getArgs();

		// 判断是否是包含Pagination(分页信息)类型,如果包含，执行分页查询
		for (Object object : args) {
			if (object instanceof Pagination) {
				Pagination<?> pagination = (Pagination<?>) object;
				//导出不计算记录总数
				if (pagination.getExportFlag() == null && pagination.getExportFlag()==1) return;
				pagination.setTotal(getCount(statementSqlId, pagination));
				break;
			}
		}
		
		long end = System.currentTimeMillis();
		
		logger.info("before " + call + "\tUse time : " + (end - start) + " ms!");
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@AfterReturning(value = "execution(* com.wenrc.reward.dao.*.*(..))",returning = "result")
	public Object AfterReturning(JoinPoint call, Object result) {
		
		long start = System.currentTimeMillis();
		
		// 判断是否是集合类型,如果不是集合类型，不需要计算count
		if (result==null||!Collection.class.isAssignableFrom(result.getClass())) {
			return result;
		}

		// 被代理对象目标方法参数
		Object[] args = call.getArgs();

		// 判断是否是包含Pagination(分页信息)类型,如果包含，执行分页查询
		for (Object object : args) {
			if (object instanceof Pagination) {
				Pagination<?> pagination = (Pagination<?>) object;
				pagination.setItems((List) result);
				break;
			}
		}

		long end = System.currentTimeMillis();
		
		logger.info("AfterReturning " + call + "\tUse time : " + (end - start) + " ms!");
		
		return result;
	}

	/**
	 * 获得记录总条数.
	 */
	private Integer getCount(String statementSqlId, Object parameterObject) {

		MappedStatement mappedStatement = sqlSessionTemplate.getConfiguration().getMappedStatement(statementSqlId);
		BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
		String sql = boundSql.getSql();
		String countSql = sql;
		SqlAssistant sqlAssistant=new MySqlSqlAssistant(sql);

		// 获取数据库名称
		try {
			if (!StringUtils.isEmpty(DATABASE_NAME)) {
				DATABASE_NAME = sqlSessionTemplate.getConfiguration().getEnvironment().getDataSource().getConnection()
						.getMetaData().getDatabaseProductName();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		// 获得处理后的sql
		if (DatabaseEnum.ORACLE.getDatabaseName().equalsIgnoreCase(DATABASE_NAME)) {
			sqlAssistant=new OracleSqlAssistant(sql);
			countSql = sqlAssistant.removeLimit().wrapSelectCount().toString();
		} else {
			countSql = sqlAssistant.removeLimit().wrapSelectCount().toString();
		}
		
		List<ParameterMapping> parameterList = boundSql.getParameterMappings();
		Iterator<ParameterMapping> it = parameterList.iterator();

		while (it.hasNext()) {
			ParameterMapping parameterMapping = it.next();
			if (SqlAssistant.REMOVE_PARAMETER.contains(parameterMapping.getProperty())) {
				it.remove();
			}
		}
		
		logger.info("\n"+"println countSql:" +"\n"+ SqlFormat.format(countSql));
		BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterList,
				parameterObject);
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject,
				countBoundSql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection=null;
		int totalRecord = 0;

		try {
			connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
			pstmt = connection.prepareStatement(countSql);
			parameterHandler.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalRecord = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return totalRecord;
	}
}
