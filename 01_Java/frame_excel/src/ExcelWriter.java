import java.io.*;

import org.apache.poi.hssf.usermodel.*;

/* 
  	Excel�� ������ �б� ���⸦ �ϱ� ���ؼ��� framework�� �ʿ��ϴ�.
  
  	POI�ٿ�ε�
  
  	https://jakarta.apache.org ���� ���� ī�׷ΰ����� POI����
  	
  	Build Path -> ������Ʈ���� ���콺 ������ Ű
  	
  	
  	
  	2.Logging �ٿ�ε�
  	
 *https:/jakarta.apache.org���� logging -> apache -log4j -2.17.2-bin.zip���� �ٿ�ε��� �����н�
 *
 *
 *
 *
 *
 */


public class ExcelWriter {
	public ExcelWriter()	{
		//������ ����
		//1.workbook ����
		HSSFWorkbook workbook =new HSSFWorkbook();
		
		//2.sheet ����
		
		HSSFSheet sheet1 = workbook.createSheet("ȸ�����");
		HSSFSheet sheet2 = workbook.createSheet();
		
		//3.row ����
		
		sheet1.createRow(0); // 0�� ����
		
		HSSFRow row0 = sheet1.createRow(0);
		
		//4.cell ����
		HSSFCell cell0= row0.createCell(0);		
		cell0.setCellValue("��ȣ");
		
		row0.createCell(1).setCellValue("�̸�");
		row0.createCell(2).setCellValue("����ó");
		
		HSSFRow row1= sheet1.createRow(1);		
		row1.createCell(0).setCellValue(1);	
		row1.createCell(1).setCellValue("ȫ�浿");
		row1.createCell(2).setCellValue("010-1234-5678");
		
		HSSFRow row2= sheet1.createRow(2);		
		row2.createCell(0).setCellValue(2);	
		row2.createCell(1).setCellValue("ȫ�浿");
		row2.createCell(2).setCellValue("010-1234-5678");
		
		HSSFRow row3= sheet1.createRow(3);		
		row3.createCell(0).setCellValue(3);	
		row3.createCell(1).setCellValue("ȫ�浿");
		row3.createCell(2).setCellValue("010-1234-5678");
		
		//���Ϸ� ����
		try {
		File f = new File("d://dev/java.xls");
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		}catch(FileNotFoundException e) {
			System.out.print("������ ������" +e.getMessage());
		}catch(IOException ie) {
			System.out.print("����� ����" +ie.getMessage());
		}
		System.out.print("excel write �Ϸ�");
	}
		
		public static void main(String[] args) {
			new ExcelWriter(); //2���� ����
	}

}
