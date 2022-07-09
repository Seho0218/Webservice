package 문제;

import java.util.*;
public class EmailCheckEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String email = " ", id = "", domain= " ", email2=" ";
		int i = 0;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.printf("이메일 = ");
		email = scan.next();
		System.out.printf("아이디 = ");
		id = scan.next();
		System.out.printf("도메인 = ");
		domain = scan.next();
		
		//email = (ghdtpgh8913@gmail.com);
		
		StringBuffer a = new StringBuffer(email);
		StringBuffer b = new StringBuffer(email2);
		
		
		
		//System.out.printf(result)
		
		
		System.out.printf("다시하시겠습니까(1.예, 2.아니오)? ");
		i = scan.nextInt();
		
		if(i==1) {
			
			
			
			System.out.printf("이메일 = ");
			email2 = scan.next();
			
			int result1 = a.compareTo(b);
			System.out.print(result1);
			
		
		
	}	
		
	}

}
