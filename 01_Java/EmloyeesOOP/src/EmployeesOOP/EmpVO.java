package EmployeesOOP;

public class EmpVO {
	private int mem_id;
	private String username;
	private String depart;
	private String tel;
	private String email;
	private String writedown;
	private String fieldName; //수정할 항목을 저장
	
	public int getMem_id() {return mem_id;}
	public void setMem_id(int mem_id) {this.mem_id = mem_id;}
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getDepart() {return depart;}
	public void setDepart(String depart) {this.depart = depart;}
	public String getFieldName() {return fieldName;}
	public void setFieldName(String fieldName) {this.fieldName = fieldName;}
	public String getPhone() {return tel;}
	public void setPhone(String phone) {this.tel = phone;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getWritedown() {return writedown;}
	public void setWritedown(String writedown) {this.writedown = writedown;}
}
