package basic01;

import java.lang.System;
import java.util.Scanner;

public class variableEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int a = scan.nextInt(); 
		
		a = a>0 && a<100  ?  a*100 : 0;  
		
		System.out.print("�Է¼��� : "+a);
	}

}
