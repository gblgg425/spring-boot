package com.grapro.bms.modules.common.vo;

import com.grapro.bms.modules.common.constant.SystemConstant;

/**
 * 查询参数
 * 
 */
public class SearchVo {

	//private String userDepart;
	private String entryStart;
	private String entryEnd;
	private String birthRange;
	private String userName;
	private int userId;
	//private String applyType;
	//private String propertyType;
	//private String propertyModel;
	//private String propertyName;
	private int currentPage;
	private int pageSize;
	
	public static void initSearchVo(SearchVo searchVo) {
		searchVo.setCurrentPage(searchVo.getCurrentPage() > 0 ? 
				searchVo.getCurrentPage() : SystemConstant.DEFAULT_CURRENT_PAGE);
		searchVo.setPageSize(SystemConstant.DEFAULT_PAGE_SIZE);
	}

	

	public String getEntryStart() {
		return entryStart;
	}

	public void setEntryStart(String entryStart) {
		this.entryStart = entryStart;
	}

	public String getEntryEnd() {
		return entryEnd;
	}

	public void setEntryEnd(String entryEnd) {
		this.entryEnd = entryEnd;
	}

	public String getBirthRange() {
		return birthRange;
	}

	public void setBirthRange(String birthRange) {
		this.birthRange = birthRange;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
}
