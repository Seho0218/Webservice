package module;

import java.io.*;
import java.util.*;

public class EmpDataSet {
	//��� ������ ������ �÷��� ����
																			//���⿡ ����
	public static HashMap<Integer,EmpVO> empList = new HashMap<Integer,EmpVO>();
	public EmpDataSet() {
	}
		
		//���Ͽ� �ִ� Object�� ���Ͽ�HashMap�� ����
		public static void dataSet(){
		try {
			
			File f = new File("c://oa","salve.txt");
			
			if(f.exists()) {//������ ���� ���
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			EmpDataSet.empList = (HashMap)ois.readObject(); //�ʱ�ȸ�� ���;
			}
		}catch(Exception e) {
			e.printStackTrace();
	}
	
	}
}

