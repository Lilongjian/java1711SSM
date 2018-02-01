package com.situ.ssm.vo;

import java.util.List;

public class PageBean<T> {
	private Integer pageNo;
	private Integer PageSzie;
	private Integer totalCount;
	private Integer totalPage;
	private List<T> list;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSzie() {
		return PageSzie;
	}
	public void setPageSzie(Integer pageSzie) {
		PageSzie = pageSzie;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", PageSzie=" + PageSzie + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	}
	
	

}
