package basic01;

import java.lang.System;
import java.util.Scanner;

public class StandardWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int gender;
		
		double height,weight = 0,stdweight = 0,bmi=0;
		
		String evl;
		
			bmi =(weight/stdweight)*100;
		
		System.out.print("���� �Է�: ");
		int age = scan.nextInt(); 
		
		System.out.print("���� : 1.��  2.�� ");
		gender = scan.nextInt(); 
		
		
		System.out.print("Ű: ");
		height = scan.nextInt(); 
		
		System.out.print("���� ü��: ");
		weight = scan.nextInt(); 
		
		
		if(0<=age && age<36)
		{
			switch(gender) {
			
			case 1:
				
				stdweight = (height - 100)*0.90;
				
			break;
				
			case 2:
			
			    stdweight= (height - 100)*0.85;
			 break;
			 
			 default:
				 System.out.println("ERROR" );
			  
			}
			
		
			
			
			if(126<=bmi)   	
				evl = "����";
			else if(116<=bmi)
				evl = "���� ����";
			else if(96<=bmi)		
				evl = " ǥ����";
			else if(86<=bmi)	
				evl = "���ݸ�����";
			else								
				evl = "������";
			
			System.out.printf("ǥ�� ü�� :%f \n", stdweight );
			System.out.printf("����� ǥ��ü��������  %f ���� %s �Դϴ�.",bmi,evl );
			
			
		}
		
		else if(age>=36)
		{
			switch(gender)
			{
		
			case 1:
				stdweight = (height - 100)*0.95;
			break;
			
			case 2:
				stdweight= (height - 100)*0.90;
			break;
			 
			default:
				 System.out.println("ERROR" );
							 			
			}
			
			bmi =(weight/stdweight)*100;
			
			if(126<=bmi)   	
				evl = "����";
			else if(116<=bmi)
				evl = "���� ����";
			else if(96<=bmi)		
				evl = " ǥ����";
			else if(86<=bmi)	
				evl = "���ݸ�����";
			else								
				evl = "������";
			
			System.out.printf("ǥ�� ü�� :%f \n", stdweight );
			System.out.printf("����� ǥ��ü��������  %f ���� %s �Դϴ�.",bmi,evl );
		}
			else
				System.out.println("ERROR" );
		
		
	}
}
