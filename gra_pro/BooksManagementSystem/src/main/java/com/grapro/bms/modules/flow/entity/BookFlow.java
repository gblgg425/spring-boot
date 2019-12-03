package com.grapro.bms.modules.flow.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *图书流动表
 */
@Entity
@Table(name = "book_flow")
public class BookFlow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookFolwId;
	private int bookId;
	private String bookNum;
	private String bookName;
	private double bookPrice;
	// 入库时间
	private Date storageTime;
	// 处理人员
	private String approveUserName;
	
	public int getBookFolwId() {
		return bookFolwId;
	}
	public void setBookFolwId(int bookFolwId) {
		this.bookFolwId = bookFolwId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Date getStorageTime() {
		return storageTime;
	}
	public void setStorageTime(Date storageTime) {
		this.storageTime = storageTime;
	}
	public String getApproveUserName() {
		return approveUserName;
	}
	public void setApproveUserName(String approveUserName) {
		this.approveUserName = approveUserName;
	}
	
	
}
