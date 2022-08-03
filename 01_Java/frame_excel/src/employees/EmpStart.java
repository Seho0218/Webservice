package employees;

import java.io.*;
import java.util.*;
import module.EmpDataSet;
import module.EmpVO;


public class EmpStart {
	Scanner scan = new Scanner(System.in);
	
	public EmpStart() {
		//���� ��ϵǾ� �ִ� ������
		EmpDataSet.dataSet();// �ʱ� ������ ����
		
		do {
			try {
			System.out.print(menu());
			int inMenu = Integer.parseInt(scan.nextLine());
			if(inMenu ==5) {//����
				empStop();
			}else if(inMenu==1) {//(��� ����� ���)
				empListOutput();
			}else if(inMenu==2) {//������
				empInsert();
			}else if(inMenu==3) {//��� ����
				empEdit();
			}else if(inMenu ==4){
				empDel();
			}else if(inMenu == 6){
				empFind();
			}
			}catch(Exception e) {
				System.out.println("�޴��� �߸� �Է��ϼ̽��ϴ�.");
			}
		}while(true);		
	}
	
		//�������
	public void empDel(){		
		System.out.print("������ ��� ��ȣ ->");
		int empno=Integer.parseInt(scan.nextLine());
		EmpDataSet.empList.remove(empno);//��ü ������
		System.out.println(empno + "�� ����� ������ �����߽��ϴ�..");		
	}
	
	
	
	public void empEdit() {
		//������ ������ ������ �Է¹޴´�.
		System.out.print("������ ��� ��ȣ ->");
		int editEmpno=Integer.parseInt(scan.nextLine());
		
		System.out.print("������ �׸�[1,�μ���, 2.����ó]->");
		String editMenu = scan.nextLine();
		if(editMenu.equals("1")) {
			departmentEdit(editEmpno);
			
		}else if(editMenu.equals("2")) {//����ó ����
			telEdit(editEmpno);
			
		}else {
			System.out.println("������ �޴��� �߸������Ͽ����ϴ�.");
		}
	}
	
	
	//�μ��� ����
	public void departmentEdit(int empno) {
		EmpVO vo = EmpDataSet.empList.get(empno);
		System.out.print("������ �μ���->");
		String editDepartName =scan.nextLine();
		vo.setDepartment(editDepartName);//�μ����� �����.
		System.out.println(vo.getEmpName()+"�� �μ����� "+vo.getDepartment()+"�� ����Ǿ����ϴ�.");
	}
	
	//����ó ����
	public void telEdit(int empno) {
		EmpVO vo  = EmpDataSet.empList.get(empno);
		System.out.print("������ ����ó ->");
		vo.setTel(scan.nextLine());
		System.out.println(vo.getEmpName()+"����� ����ó�� "+vo.getTel()+"�� ����Ǿ����ϴ�.");
	}
	
	
	
	//��� ���
	public void empListOutput() {
		titlePrint();//�������
		//���� ��� value(vo��ü)�� ���Ͽ� ����� ����Ѵ�
		Collection<EmpVO> emp = EmpDataSet.empList.values();
		Iterator<EmpVO> i = emp.iterator();	
		
		while(i.hasNext()) {
			EmpVO v = i.next();
			System.out.println(v.toString());
		}
	}
	
	//��� �˻�
	public void empFind() {
		System.out.println("�˻��� �����(���ڷ�)");
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
	System.out.println(cnt+"���� �˻��Ǿ����ϴ�.");
	
	}
	

	public void titlePrint() {
		System.out.println("�����ȣ\t �����\t�μ���\t����ó");
	}
	
	public void empInsert() {
		EmpVO vo = new EmpVO();//�Է¹��� ��������� ������ VO
		System.out.print("�����ȣ->");
		vo.setEmpno(Integer.parseInt(scan.nextLine()));
		System.out.print("�����->");
		vo.setEmpName(scan.nextLine());
		System.out.print("�μ���->");
		vo.setDepartment(scan.nextLine());
		System.out.print("����ó->");
		vo.setTel(scan.nextLine());
		
		//�÷��ǿ� VO�� �߰�
		EmpDataSet.empList.put(vo.getEmpno(), vo);
		System.out.println("����� ��ϵǾ����ϴ�.");
	}
		
	public void empStop() {
		try {
		//��� ������ �ִ� empList�� ���Ϸ� �����ϰ� ����
		File f = new File("c://oa","salve.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(EmpDataSet.empList);
		
		oos.close();
		fos.close();
		
		}catch(Exception e) {
			System.out.println("��� ���� ���ܹ߻�!!"+e.getMessage());
		}
		System.exit(0);
	}
	

	public String menu() {
		return "�޴� [1.������, 2.������, 3.�������, 4.�������, 5.����. 6. �˻�(�����)] -> ";
	}
		public static void main(String[] args) {
			new EmpStart();
	//4�� 13�к��� �̷�
		}
	
	}
