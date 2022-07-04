package EmployeesOOP;

import java.util.List;
import java.util.Scanner;

public class EmpStart {
	Scanner scan = new Scanner(System.in);
	EmpDAO dao = new EmpDAO();
	public EmpStart() {start();}
	public void start() {
		do {
			String menu = menuShow();
			
			if(menu.equals("1")) {empList();
			}else if(menu.equals("2")) {empAdd();
			}else if(menu.equals("3")) {//20분 설명
				empEdit();
			}else if(menu.equals("4")) {empDel();
			}else if(menu.equals("5")) {empClose();
			}else if(menu.equals("6")){empSearch();}
		
		}while(true);
	}
	//검색
	public void empSearch() {
		System.out.print("검색어 -> ");
		String searchWord = scan.nextLine();
		
		empPrint(dao.empSelect(searchWord));
	//출력
	}
	//회원목록
	public void empList() {
		//회원목록 DB에서 선택할 수 있는 메소드를 호출
		//EmpDAO dao = EmpDAO.getInstance();
		//EmpDAO dao = new EmpDAO();
		String searchWord = null;
		empPrint(dao.empSelect(searchWord));	
	}
	//목록출력
	public void empPrint(List<EmpVO> list) {
		for(int i = 0; i<list.size();i++) {
			EmpVO vo = list.get(i);
			System.out.printf("%6d %12s %10s %16s %20s\n",vo.getMem_id(),vo.getUsername(),vo.getDepart(),vo.getPhone(),vo.getEmail() );
		}
	}
	//회원삭제
	public void empDel() {
		System.out.print("삭제할 회원 번호 -> ");
		int mem_id = Integer.parseInt(scan.nextLine());
	
		int result = dao.empDelete(mem_id);
		if(result >0) {
			System.out.println(mem_id+"회원이 삭제되었습니다.");
		}
	}
	//회원추가
	public void empAdd() {
		//회원번호, 이름, 부서명, 연락처, 이메일
		// 입력받은 데이터를 VO저장하기 위해서 객체를 생성
		EmpVO vo = new EmpVO();
		System.out.printf("회원번호 ->");
		vo.setMem_id(Integer.parseInt(scan.nextLine()));
		System.out.printf("이름 ->");
		vo.setUsername(scan.nextLine());
		System.out.printf("부서명 ->");
		vo.setDepart(scan.nextLine());
		System.out.printf("연락처 ->");
		vo.setPhone(scan.nextLine());
		System.out.printf("이메일 ->");
		vo.setEmail(scan.nextLine());
		dao.empInsert(vo);
	}	//회원수
	public void empEdit() {
		EmpVO vo = new EmpVO();//여기 좀 중요하게 다시 볼 것.
		
		System.out.print("수정할 회원번호 ->");
		vo.setMem_id(Integer.parseInt(scan.nextLine()));
		
		System.out.print("수정할 항목 선택[1.연락처,2.부서명,3.이메일] - >");
		String editField = scan.nextLine();
		
		if(editField.equals("1")) {
			vo.setFieldName("tel");
			System.out.print("수정할 연락처");
		}else if(editField.equals("2")) {
			vo.setFieldName("depart");
			System.out.print("수정할 부서명");
		}else if(editField.equals("3")) {
			vo.setFieldName("email");
			System.out.print("수정할 이메일");
		}vo.setPhone(scan.nextLine());
		dao.empUpdate(vo);
		int cnt = dao.empUpdate(vo);
		if(cnt>0) {
			System.out.print("수정");
		}else {
			System.out.print("수정실패");
		}
	}
	public void empClose() {
		System.exit(0);
	}
	public String menuShow() {
		System.out.print("메뉴[1.회원목록 2. 회원등록 3.회원수정 4.회원삭제 5.종료 6.검색] -> ");
		return scan.nextLine();
	}	
	public static void main(String[] args) {
		new EmpStart();
	}}
