package basic01;

import java.lang.System;
import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		String flnm = "";
		System.out.println("1.해바라기, 2.코스모스, 3.장미 ");
		int num = scan.nextInt(); 
		
		
		
		switch(num) {
		
		case 1:
			flnm = "해바라기";
		break;
					
		case 2:
			flnm = "코스모스";
			break;

		case 3:
			flnm = "장미";
			break;

		default:
			flnm = "예외";
			}
		
		System.out.println("꽃 이름: " + flnm);
		
	}
	

}
