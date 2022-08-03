package frame_excel;

import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.*;

public class ExcelRead {
	public ExcelRead(){}
	public void start() {
		try {
			File f = new File("d://dev","java.xls");
			FileInputStream fis = new FileInputStream(f);
			//액셀파일을 객체 생성하기
			POIFSFileSystem poi = new POIFSFileSystem(fis); //poi <- 여기에 workbook이 있단
			//1.workbook 구하기
			HSSFWorkbook book = new HSSFWorkbook(poi);
			
			//1.workbook 구하기
			int sheetCnt=book.getNumberOfSheets();
			System.out.println("시트수 ->"+sheetCnt);
			
			//2. 회원 목록 시트 객체 얻어오기
			
			HSSFSheet sheet = book.getSheet("회원목록");
			
			//행의 수 구하기
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("행의 수 ->"+rowCount);
			
			System.out.println("번호\t이름 \t\t연락처");
			
			//43분부터 설명
			for(int idx= 1;idx<rowCount;idx++) {//1,2,3
				HSSFRow row =sheet.getRow(idx); //엑셀은 int형이 없다
				
				int cellCount =row.getPhysicalNumberOfCells();//셀의 수
				
				for(int i = 0; i<cellCount; i++) {
					HSSFCell cell = row.getCell(i);
					if(i==0) {//번호
						int num = (int) row.getCell(i).getNumericCellValue();//숫자 double
						System.out.print(num+ "\t");
					}else {//이름, 연락처
						String str = row.getCell(i).getStringCellValue(); //문자 String
						System.out.print(str+ "\t");
					}
				}
				System.out.println();							
			}			
		}catch(Exception e) {
			e.printStackTrace();			
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExcelRead().start();
	}
}
