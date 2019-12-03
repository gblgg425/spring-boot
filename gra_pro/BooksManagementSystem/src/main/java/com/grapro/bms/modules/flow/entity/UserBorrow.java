package com.grapro.bms.modules.flow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *用户借阅表
 */
@Entity
@Table(name = "user_borrow")
public class UserBorrow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userBorrowId;
	private int userId;
	private int borrowId;
	
	public int getUserBorrowId() {
		return userBorrowId;
	}
	public void setUserBorrowId(int userBorrowId) {
		this.userBorrowId = userBorrowId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	
	

}
