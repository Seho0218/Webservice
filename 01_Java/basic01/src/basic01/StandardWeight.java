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
		
		System.out.print("나이 입력: ");
		int age = scan.nextInt(); 
		
		System.out.print("성별 : 1.남  2.여 ");
		gender = scan.nextInt(); 
		
		
		System.out.print("키: ");
		height = scan.nextInt(); 
		
		System.out.print("현재 체중: ");
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
				evl = "비만형";
			else if(116<=bmi)
				evl = "조금 비만형";
			else if(96<=bmi)		
				evl = " 표준형";
			else if(86<=bmi)	
				evl = "조금마른형";
			else								
				evl = "마른형";
			
			System.out.printf("표준 체중 :%f \n", stdweight );
			System.out.printf("당신은 표준체중지수는  %f 으로 %s 입니다.",bmi,evl );
			
			
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
				evl = "비만형";
			else if(116<=bmi)
				evl = "조금 비만형";
			else if(96<=bmi)		
				evl = " 표준형";
			else if(86<=bmi)	
				evl = "조금마른형";
			else								
				evl = "마른형";
			
			System.out.printf("표준 체중 :%f \n", stdweight );
			System.out.printf("당신은 표준체중지수는  %f 으로 %s 입니다.",bmi,evl );
		}
			else
				System.out.println("ERROR" );
		
		
	}
}
