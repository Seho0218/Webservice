package basic01;

import java.lang.System;
import java.util.Scanner;

public class Switch02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		String season;
		
		System.out.println("�� �Է�: ");
		int month = scan.nextInt(); 
		
switch(month) {
		
		case 11:
		case 12:
		case 1:					
		case 2:
			season = "�ܿ�";
			break;

		case 3:
			season = "���";
			break;

		default:
			season = "����";
			}

	}

}
