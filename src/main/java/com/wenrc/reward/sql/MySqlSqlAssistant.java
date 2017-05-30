package com.wenrc.reward.sql;

/**
 * 
 * @author wen_rc@sina.com 2017年5月16日
 *
 */
public class MySqlSqlAssistant extends SqlAssistant {

	public MySqlSqlAssistant() {
	}

	public MySqlSqlAssistant(String sql) {
		super(sql);
	}

	/**
	 * 去掉limit.
	 */
	@Override
	public SqlAssistant removeLimit() {
		sql = sql.replaceAll(LIMIT_REGEX, "");
		return this;
	}
}
