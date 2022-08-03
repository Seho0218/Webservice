package java_report_book;

import java.io.*;
import java.util.*;

import module.BookInfo;
import module.ManageBook;

public class BookDataSet {
	
	public static HashMap<Integer,BookInfo> bookList = new HashMap<Integer,BookInfo>();
	public BookDataSet() {}
		
		public static void dataSet(){			
		try {
			File f = new File("/Users/hongseho/Desktop/project2/java_report_book","book.txt");
			
			if(f.exists()) {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			BookDataSet.bookList = (HashMap)ois.readObject();			
			ois.close();
			fis.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}	
			}
		}
