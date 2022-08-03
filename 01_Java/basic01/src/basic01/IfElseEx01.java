package basic01;

import java.lang.*;
import java.util.*;

public class IfElseEx01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("1. 사각형의 넓이, 2.원의 넓이: ");
		int a = scan.nextInt(); 
		
		if(a==1) {
			
			System.out.println("밑변 : ");
			int a1 = scan.nextInt(); 
			
			System.out.println("높이 : ");
			int b1 = scan.nextInt(); 
			
			System.out.print("사각형의 넓이 : " +(a1*b1));
		}else
			
			
		{
			System.out.print("반지름 : ");
			int a1 = scan.nextInt(); 
			
			System.out.print("원의 넓이 : " +Math.PI*a1*a1);
			
					
		}
		

	}

}
