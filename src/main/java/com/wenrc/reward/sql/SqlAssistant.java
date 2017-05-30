package com.wenrc.reward.sql;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author wen_rc@sina.com 2017年5月16日
 *
 */
public abstract class SqlAssistant {

	protected String sql;

	// order by xx,xx desc|asc 正则表达式
	protected static final String ORDER_BY_REGEX = "(?i)ORDER(?-i)\\s*(?i)BY(?-i)\\s*([.[^,()\\s]]+)?(\\s*,[.[^,()\\s]]+)*\\s*(?i)(DESC|ASC)?(?-i)\\s*";

	// limit 0,10 正则表达式
	protected static final String LIMIT_REGEX = "(?i)LIMIT(?-i)\\s*[0-9]*\\d*\\?*\\s*(,)?\\s*[0-9]*\\d*\\?*\\s*";

	// 与order by绑定的关键字
	protected static final Set<String> ORDER_BY_BOUND = new HashSet<String>();

	// 计算select count时需要删除与分页有关的参数
	public static final Set<String> REMOVE_PARAMETER = new HashSet<String>();

	static {
		REMOVE_PARAMETER.add("firstRowNum");
		REMOVE_PARAMETER.add("lastRowNum");
		REMOVE_PARAMETER.add("pageSize");
	}

	public SqlAssistant() {
	}

	public SqlAssistant(String sql) {
		this.sql = sql;
	}

	/**
	 * 去掉order by.
	 */
	public SqlAssistant removeOrderBy() {

		//如果sql中包含与order by绑定的关键字，则不能去除order by
		for (String keyWord : ORDER_BY_BOUND) {
			if (sql.contains(keyWord)) {
				return this;
			}
		}

		sql = sql.replaceAll(ORDER_BY_REGEX, "");
		return this;
	}

	/**
	 * 去掉limit.
	 */
	public SqlAssistant removeLimit() {
		sql = sql.replaceAll(LIMIT_REGEX, "");
		return this;
	}

	/**
	 * 查询总数.
	 */
	public SqlAssistant wrapSelectCount() {
		sql = "select count(*) from (" + this.removeOrderBy().removeLimit().toString().trim() + ") t";
		return this;
	}

	/**
	 * 格式化sql.
	 */
	public SqlAssistant formatSql() {
		sql = SqlFormat.format(this.sql);
		return this;
	}

	@Override
	public String toString() {
		return this.sql;
	}
}
