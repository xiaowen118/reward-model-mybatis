package com.wenrc.reward.sql;

/**
 * 
 * @author wen_rc@sina.com 2017年5月16日
 *
 */
public class OracleSqlAssistant extends SqlAssistant {

	static {
		ORDER_BY_BOUND.add("row_number");
		ORDER_BY_BOUND.add("rank");
		ORDER_BY_BOUND.add("dense_rank");
		ORDER_BY_BOUND.add("lead");
		ORDER_BY_BOUND.add("lag");
		ORDER_BY_BOUND.add("over");
	}

	public OracleSqlAssistant() {
	}

	public OracleSqlAssistant(String sql) {
		super(sql);
	}

	/**
	 * 查询总数.
	 */
	@Override
	public SqlAssistant wrapSelectCount() {
		sql = "select count(*) from (" + this.sql.trim() + ") t";
		return this;
	}

}
