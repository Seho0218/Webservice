package module;

import java.io.*;

public class BookInfo extends Object implements Serializable {
	
	private Integer BookNum;
	private String BookName;
	private String author;
	private String publisher;
	private int year;
	
	public BookInfo() {}
	public BookInfo(Integer BookNum, String BookName,String author,String publisher,int year) {
		this.BookNum=BookNum;
		this.BookName=BookName;
		this.author=author;
		this.publisher=publisher;
		this.year = year;
	}	
	@Override
	public String toString() {
		return BookNum+ "\t" +BookName + "\t" +author+"\t"+publisher +"\t" + year;
	}
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	public Integer getBookNum() {return BookNum;}
	public void setBookNum(Integer bookNum) {BookNum = bookNum;}
	public String getBookName() {return BookName;}
	public void setBookName(String bookName) {BookName = bookName;}
	public String getAuthor() {return author;}
	public void setAuthor(String author) {this.author = author;}
	public String getPublisher() {return publisher;}
	public void setPublisher(String publisher) {this.publisher = publisher;}
	public static void main(String[] args) {
		new BookInfo();
	}
}
