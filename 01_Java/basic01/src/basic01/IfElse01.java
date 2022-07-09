package basic01;

import java.lang.System;
import java.util.Scanner;

public class IfElse01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		System.out.print("1~100 임의의 값: ");
		int b = scan.nextInt(); 
		
		if(0<b &&b<101) {System.out.print(b);}
		
		else {
			int c =b<1 ?  (-1)*b :  b;
					
					System.out.print(c);
		}
	}

}
