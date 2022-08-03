package basic01;

import java.lang.System;
import java.util.Scanner;

public class VariableEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("가로(밑변): ");
		int b = scan.nextInt(); 
		
		System.out.print("둘레(밑변): ");
		int c = scan.nextInt(); 
		
		System.out.print("1.사각형의 넓이 , 2.사각형의 둘레 : ");
		int a = scan.nextInt(); 
		
		int d = a==1 ?  b*c :  2*(b+c);
		
		
		System.out.print(a==1 ? "사각형의 넓이 :" : "2.사각형의 둘레  :" +d );
		
		
	}

}
