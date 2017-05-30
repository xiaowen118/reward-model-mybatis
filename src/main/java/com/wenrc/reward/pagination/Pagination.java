package com.wenrc.reward.pagination;

import java.util.List;

/**
 * 数据分页Bean
 * 
 * @author wenrc@szwgmf.com 2017年3月23日
 */
public class Pagination<T> {
	private int pageSize;// 每页显示数据条数
	private long total;// 数据条数
	private int pageIndex;// 当前页数
	private int firstRowNum;// 第一条记录行数
	private int lastRowNum;// 最后一条记录行数
	private List<T> items;// 数据对象
	private Integer exportFlag=0;// 导出标志(0-否;1-是)

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getFirstRowNum() {
		firstRowNum = (pageIndex - 1) * pageSize;
		return firstRowNum;
	}

	public void setFirstRowNum(int firstRowNum) {
		this.firstRowNum = firstRowNum;
	}

	public int getLastRowNum() {
		lastRowNum = pageIndex * pageSize;
		return lastRowNum;
	}

	public void setLastRowNum(int lastRowNum) {
		this.lastRowNum = lastRowNum;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public Integer getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(Integer exportFlag) {
		this.exportFlag = exportFlag;
	}

}
