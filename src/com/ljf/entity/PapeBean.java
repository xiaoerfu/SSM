package com.ljf.entity;

/**
 * 
 * @author lijianfu
 *
 */
public class PapeBean {
	
	private int page;
	private int pageSize;
	private int start;
	
	
	public PapeBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	public PapeBean(int page, int pageSize, int start) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.start = start;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	@Override
	public String toString() {
		return "PapeBean [page=" + page + ", pageSize=" + pageSize + ", start=" + start + "]";
	}
	
	
	
}
