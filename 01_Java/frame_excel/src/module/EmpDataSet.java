package module;

import java.io.*;
import java.util.*;

public class EmpDataSet {
	//사원 정보를 저장할 컬렉션 생성
																			//여기에 저장
	public static HashMap<Integer,EmpVO> empList = new HashMap<Integer,EmpVO>();
	public EmpDataSet() {
	}
		
		//파일에 있는 Object를 구하여HashMap에 셋팅
		public static void dataSet(){
		try {
			
			File f = new File("c://oa","salve.txt");
			
			if(f.exists()) {//파일이 있을 경우
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			EmpDataSet.empList = (HashMap)ois.readObject(); //초기회원 목록;
			}
		}catch(Exception e) {
			e.printStackTrace();
	}
	
	}
}

