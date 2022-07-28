package comcampus.myapp.vo;

public class MemberVO {
	private String userid;
	private String userpwd;
	private String username;
	private String tel;
	private String zipcode;
	private String addr;
	private String detailaddr;
	private String writedate;
	
	
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", tel=" + tel
				+ ", zipcode=" + zipcode + ", addr=" + addr + ", detailaddr=" + detailaddr + ", writedate=" + writedate
				+ "]";
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDetailaddr() {
		return detailaddr;
	}
	public void setDetailaddr(String detailaddr) {
		this.detailaddr = detailaddr;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	

}
