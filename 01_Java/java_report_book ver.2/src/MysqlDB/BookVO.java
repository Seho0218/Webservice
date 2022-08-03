package MysqlDB;

import java.io.*;

public class BookVO extends Object implements Serializable{
	private Integer Book_num;
	private String BookName;
	private String Author;
	private String Publisher;
	private String Statement;
	private String writedown;
	private Integer pages;
	private String FieldName; //수정할 항목을 저장
	
	public Integer getBook_num() {
		return Book_num;
	}
	public void setBook_num(Integer Book_num) {
		this.Book_num = Book_num;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getStatement() {
		return Statement;
	}
	public void setStatement(String statement) {
		this.Statement = statement;
	}
	public String getWritedown() {
		return writedown;
	}
	public void setWritedown(String writedown) {
		this.writedown = writedown;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		this.FieldName = fieldName;
	}	
}
