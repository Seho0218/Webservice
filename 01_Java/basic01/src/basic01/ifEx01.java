package basic01;

import java.lang.System;
import java.util.Scanner;


public class ifEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("�ݾ� �Է�: ");
		int b = scan.nextInt(); 
		
		if(b>10000)
		{
			if(b%10==0)
			{
				 System.out.print("��� =  " +b);
			}
			
			int c = b- (b%10);
			
			System.out.print("���: " +c);
			
		}		
		
	}

}
