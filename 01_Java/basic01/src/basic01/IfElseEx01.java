package basic01;

import java.lang.*;
import java.util.*;

public class IfElseEx01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("1. �簢���� ����, 2.���� ����: ");
		int a = scan.nextInt(); 
		
		if(a==1) {
			
			System.out.println("�غ� : ");
			int a1 = scan.nextInt(); 
			
			System.out.println("���� : ");
			int b1 = scan.nextInt(); 
			
			System.out.print("�簢���� ���� : " +(a1*b1));
		}else
			
			
		{
			System.out.print("������ : ");
			int a1 = scan.nextInt(); 
			
			System.out.print("���� ���� : " +Math.PI*a1*a1);
			
					
		}
		

	}

}
