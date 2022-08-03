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
			//�׼������� ��ü �����ϱ�
			POIFSFileSystem poi = new POIFSFileSystem(fis); //poi <- ���⿡ workbook�� �ִ�
			//1.workbook ���ϱ�
			HSSFWorkbook book = new HSSFWorkbook(poi);
			
			//1.workbook ���ϱ�
			int sheetCnt=book.getNumberOfSheets();
			System.out.println("��Ʈ�� ->"+sheetCnt);
			
			//2. ȸ�� ��� ��Ʈ ��ü ������
			
			HSSFSheet sheet = book.getSheet("ȸ�����");
			
			//���� �� ���ϱ�
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("���� �� ->"+rowCount);
			
			System.out.println("��ȣ\t�̸� \t\t����ó");
			
			//43�к��� ����
			for(int idx= 1;idx<rowCount;idx++) {//1,2,3
				HSSFRow row =sheet.getRow(idx); //������ int���� ����
				
				int cellCount =row.getPhysicalNumberOfCells();//���� ��
				
				for(int i = 0; i<cellCount; i++) {
					HSSFCell cell = row.getCell(i);
					if(i==0) {//��ȣ
						int num = (int) row.getCell(i).getNumericCellValue();//���� double
						System.out.print(num+ "\t");
					}else {//�̸�, ����ó
						String str = row.getCell(i).getStringCellValue(); //���� String
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
