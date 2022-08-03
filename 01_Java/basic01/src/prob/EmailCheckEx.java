package prob;
package ����;

import java.util.*;
public class EmailCheckEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String email = " ", id = "", domain= " ", email2=" ";
		int i = 0;
		Scanner scan = new Scanner(System.in);
		
		
		System.out.printf("�̸��� = ");
		email = scan.next();
		System.out.printf("���̵� = ");
		id = scan.next();
		System.out.printf("������ = ");
		domain = scan.next();
		
		//email = (ghdtpgh8913@gmail.com);
		
		StringBuffer a = new StringBuffer(email);
		StringBuffer b = new StringBuffer(email2);
		
		
		
		//System.out.printf(result)
		
		
		System.out.printf("�ٽ��Ͻðڽ��ϱ�(1.��, 2.�ƴϿ�)? ");
		i = scan.nextInt();
		
		if(i==1) {
			
			
			
			System.out.printf("�̸��� = ");
			email2 = scan.next();
			
			int result1 = a.compareTo(b);
			System.out.print(result1);
			
		
		
	}	
		
	}

}
