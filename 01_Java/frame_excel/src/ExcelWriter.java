import java.io.*;

import org.apache.poi.hssf.usermodel.*;

/* 
  	Excel로 내용을 읽기 쓰기를 하기 위해서는 framework가 필요하다.
  
  	POI다운로드
  
  	https://jakarta.apache.org 에서 왼쪽 카테로고리에서 POI선택
  	
  	Build Path -> 프로젝트에서 마우스 오른쪽 키
  	
  	
  	
  	2.Logging 다운로드
  	
 *https:/jakarta.apache.org에서 logging -> apache -log4j -2.17.2-bin.zip에서 다운로드후 빌드패스
 *
 *
 *
 *
 *
 */


public class ExcelWriter {
	public ExcelWriter()	{
		//엑셀로 쓰기
		//1.workbook 생성
		HSSFWorkbook workbook =new HSSFWorkbook();
		
		//2.sheet 생성
		
		HSSFSheet sheet1 = workbook.createSheet("회원목록");
		HSSFSheet sheet2 = workbook.createSheet();
		
		//3.row 생성
		
		sheet1.createRow(0); // 0행 생성
		
		HSSFRow row0 = sheet1.createRow(0);
		
		//4.cell 생성
		HSSFCell cell0= row0.createCell(0);		
		cell0.setCellValue("번호");
		
		row0.createCell(1).setCellValue("이름");
		row0.createCell(2).setCellValue("연락처");
		
		HSSFRow row1= sheet1.createRow(1);		
		row1.createCell(0).setCellValue(1);	
		row1.createCell(1).setCellValue("홍길동");
		row1.createCell(2).setCellValue("010-1234-5678");
		
		HSSFRow row2= sheet1.createRow(2);		
		row2.createCell(0).setCellValue(2);	
		row2.createCell(1).setCellValue("홍길동");
		row2.createCell(2).setCellValue("010-1234-5678");
		
		HSSFRow row3= sheet1.createRow(3);		
		row3.createCell(0).setCellValue(3);	
		row3.createCell(1).setCellValue("홍길동");
		row3.createCell(2).setCellValue("010-1234-5678");
		
		//파일로 쓰기
		try {
		File f = new File("d://dev/java.xls");
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		}catch(FileNotFoundException e) {
			System.out.print("파일이 없을때" +e.getMessage());
		}catch(IOException ie) {
			System.out.print("입출력 예외" +ie.getMessage());
		}
		System.out.print("excel write 완료");
	}
		
		public static void main(String[] args) {
			new ExcelWriter(); //2교시 까지
	}

}
