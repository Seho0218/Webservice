package basic01;

import java.lang.System;
import java.util.Scanner;
public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		System.out.print("����� ���� : ");
		int a = scan.nextInt(); 
		
		int b = (a%10 != 0) ?  a/10+1 : a/10 ;  
		
		System.out.printf("�ʿ��� �ٱ��� �� : " + b);
		
	}

}
