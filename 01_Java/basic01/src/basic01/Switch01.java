package basic01;

import java.lang.System;
import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		String flnm = "";
		System.out.println("1.�عٶ��, 2.�ڽ���, 3.��� ");
		int num = scan.nextInt(); 
		
		
		
		switch(num) {
		
		case 1:
			flnm = "�عٶ��";
		break;
					
		case 2:
			flnm = "�ڽ���";
			break;

		case 3:
			flnm = "���";
			break;

		default:
			flnm = "����";
			}
		
		System.out.println("�� �̸�: " + flnm);
		
	}
	

}
