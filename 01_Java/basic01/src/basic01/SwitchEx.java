package basic01;

import java.lang.System;
import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		char grade;
		
		System.out.print("���� ���� : ");
		int kor = scan.nextInt(); 
		
		System.out.print("���� ���� : ");
		int eng = scan.nextInt(); 
		
		System.out.print("���� ���� : ");
		int math = scan.nextInt(); 
		
		double avg = (kor+eng+math)/3;
		int total = kor+eng+math;
		
		
		switch((int)avg/10) {
		
		case 10:
		case 9:
			grade = 'A';
		break;

		case 8:
			grade = 'B';
		break;
		
		case 7:
			grade = 'C';		
		break;
			
		case 6:
			grade = 'D';
		break;
		
		default:
			grade = 'F';
		}
		
		System.out.printf("���� : %d, ���: %.2f, ����: %c", total,avg,grade);
		
		
	}
	

}
