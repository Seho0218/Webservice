package basic01;

import java.lang.System;
import java.util.Scanner;

public class ForEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("2~9�� ���� �Է� :");
		int num = scan.nextInt(); 
		
		if(1<num && num<10) {
		
			for(int i=1 ; i<10; i++)
		
				System.out.printf("%d * %d = %d\n",num,i,num*i);
		}
		
		else
			
			System.out.printf("���� �߸� �Է��Ͽ���");	
	}
}
