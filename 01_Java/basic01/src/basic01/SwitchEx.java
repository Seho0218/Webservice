package basic01;

import java.lang.System;
import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		char grade;
		
		System.out.print("국어 점수 : ");
		int kor = scan.nextInt(); 
		
		System.out.print("영어 점수 : ");
		int eng = scan.nextInt(); 
		
		System.out.print("수학 점수 : ");
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
		
		System.out.printf("총점 : %d, 평균: %.2f, 학점: %c", total,avg,grade);
		
		
	}
	

}
