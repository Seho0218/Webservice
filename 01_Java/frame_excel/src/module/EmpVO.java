package module;

import java.io.*;

public class EmpVO extends Object implements Serializable{
	private int empno;
	private String empName;
	private String tel;
	private String department;

	public EmpVO(){
		
		
	}
	public EmpVO(int empno, String empName, String department, String tel) {
		this.empno = empno;
		this.empName= empName;
		this.department= department;
		this.tel=tel;
	}
	
	
	@Override
	public String toString() {
		return empno+"\t" +empName + "\t"+ department + "\t" + tel;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
		public static void main(String[] args) {
			new EmpVO(); 
			
		}	
	}

	

