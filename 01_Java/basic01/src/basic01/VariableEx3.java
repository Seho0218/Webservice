package basic01;

import java.lang.System;
import java.util.Scanner;

public class VariableEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("����(�غ�): ");
		int b = scan.nextInt(); 
		
		System.out.print("�ѷ�(�غ�): ");
		int c = scan.nextInt(); 
		
		System.out.print("1.�簢���� ���� , 2.�簢���� �ѷ� : ");
		int a = scan.nextInt(); 
		
		int d = a==1 ?  b*c :  2*(b+c);
		
		
		System.out.print(a==1 ? "�簢���� ���� :" : "2.�簢���� �ѷ�  :" +d );
		
		
	}

}
