package basic01;

import java.lang.System;
import java.util.Scanner;

public class IfElseIfEx01 {

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
		
		if(90<=avg)		grade = 'A';
		
		else if (80<=avg) grade = 'B';
		
		else if (70<=avg) grade = 'C';
		
		else if (60<=avg) grade = 'D';
		
		else grade = 'F';
		
		System.out.println("����: " + total);
		System.out.println("���: " +avg);
		System.out.println("����: " +grade);
	}
}
