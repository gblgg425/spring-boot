package com.grapro.bms.modules.flow.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *报废图书
 */
@Entity
@Table(name = "scrap_book")
public class ScrapBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scrapId;
	private int bookId;
	private String bookNum;
	private String bookName;
	private double bookPrice;
	private String bookType;
	private String bookStatus;
	
	public int getScrapId() {
		return scrapId;
	}
	public void setScrapId(int scrapId) {
		this.scrapId = scrapId;
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
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	
}
