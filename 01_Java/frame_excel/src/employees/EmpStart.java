package employees;

import java.io.*;
import java.util.*;
import module.EmpDataSet;
import module.EmpVO;


public class EmpStart {
	Scanner scan = new Scanner(System.in);
	
	public EmpStart() {
		//현재 등록되어 있는 사원목록
		EmpDataSet.dataSet();// 초기 데이터 설정
		
		do {
			try {
			System.out.print(menu());
			int inMenu = Integer.parseInt(scan.nextLine());
			if(inMenu ==5) {//종료
				empStop();
			}else if(inMenu==1) {//(모든 사원의 목록)
				empListOutput();
			}else if(inMenu==2) {//사원등록
				empInsert();
			}else if(inMenu==3) {//사원 수정
				empEdit();
			}else if(inMenu ==4){
				empDel();
			}else if(inMenu == 6){
				empFind();
			}
			}catch(Exception e) {
				System.out.println("메뉴를 잘못 입력하셨습니다.");
			}
		}while(true);		
	}
	
		//사원삭제
	public void empDel(){		
		System.out.print("삭제할 사원 번호 ->");
		int empno=Integer.parseInt(scan.nextLine());
		EmpDataSet.empList.remove(empno);//객체 지워짐
		System.out.println(empno + "번 사원의 정보를 삭제했습니다..");		
	}
	
	
	
	public void empEdit() {
		//어떤사원을 수정할 것인지 입력받는다.
		System.out.print("수정할 사원 번호 ->");
		int editEmpno=Integer.parseInt(scan.nextLine());
		
		System.out.print("수정할 항목[1,부서명, 2.연락처]->");
		String editMenu = scan.nextLine();
		if(editMenu.equals("1")) {
			departmentEdit(editEmpno);
			
		}else if(editMenu.equals("2")) {//연락처 수정
			telEdit(editEmpno);
			
		}else {
			System.out.println("수정할 메뉴를 잘못선택하였습니다.");
		}
	}
	
	
	//부서명 수정
	public void departmentEdit(int empno) {
		EmpVO vo = EmpDataSet.empList.get(empno);
		System.out.print("수정할 부서명->");
		String editDepartName =scan.nextLine();
		vo.setDepartment(editDepartName);//부서명이 변경됨.
		System.out.println(vo.getEmpName()+"의 부서명이 "+vo.getDepartment()+"로 변경되었습니다.");
	}
	
	//연락처 수정
	public void telEdit(int empno) {
		EmpVO vo  = EmpDataSet.empList.get(empno);
		System.out.print("수정할 연락처 ->");
		vo.setTel(scan.nextLine());
		System.out.println(vo.getEmpName()+"사원의 연락처가 "+vo.getTel()+"로 변경되었습니다.");
	}
	
	
	
	//사원 목록
	public void empListOutput() {
		titlePrint();//제목출력
		//맵의 모든 value(vo객체)를 구하여 목록을 출력한다
		Collection<EmpVO> emp = EmpDataSet.empList.values();
		Iterator<EmpVO> i = emp.iterator();	
		
		while(i.hasNext()) {
			EmpVO v = i.next();
			System.out.println(v.toString());
		}
	}
	
	//사원 검색
	public void empFind() {
		System.out.println("검색할 사원명(문자로)");
		String mpName = scan.nextLine();
		Collection<EmpVO> list  = EmpDataSet.empList.values();
		Iterator<EmpVO> ii = list.iterator();
		int cnt = 0;
		while(ii.hasNext()) {
			EmpVO v = ii.next();
			if(v.getEmpName().equals(mpName)) {
				System.out.println(v.toString());
				cnt++;		
			}
		}
	System.out.println(cnt+"명이 검색되었습니다.");
	
	}
	

	public void titlePrint() {
		System.out.println("사원번호\t 사원명\t부서명\t연락처");
	}
	
	public void empInsert() {
		EmpVO vo = new EmpVO();//입력받은 사원정보를 저장할 VO
		System.out.print("사원번호->");
		vo.setEmpno(Integer.parseInt(scan.nextLine()));
		System.out.print("사원명->");
		vo.setEmpName(scan.nextLine());
		System.out.print("부서명->");
		vo.setDepartment(scan.nextLine());
		System.out.print("연락처->");
		vo.setTel(scan.nextLine());
		
		//컬렉션에 VO를 추가
		EmpDataSet.empList.put(vo.getEmpno(), vo);
		System.out.println("사원이 등록되었습니다.");
	}
		
	public void empStop() {
		try {
		//사원 정보가 있는 empList를 파일로 저장하고 종료
		File f = new File("c://oa","salve.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(EmpDataSet.empList);
		
		oos.close();
		fos.close();
		
		}catch(Exception e) {
			System.out.println("사원 저장 예외발생!!"+e.getMessage());
		}
		System.exit(0);
	}
	

	public String menu() {
		return "메뉴 [1.사원목록, 2.사원등록, 3.사원수정, 4.사원삭제, 5.종료. 6. 검색(사원명)] -> ";
	}
		public static void main(String[] args) {
			new EmpStart();
	//4시 13분부터 이론
		}
	
	}
