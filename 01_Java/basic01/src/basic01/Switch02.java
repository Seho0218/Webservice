package basic01;

import java.lang.System;
import java.util.Scanner;

public class Switch02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		String season;
		
		System.out.println("월 입력: ");
		int month = scan.nextInt(); 
		
switch(month) {
		
		case 11:
		case 12:
		case 1:					
		case 2:
			season = "겨울";
			break;

		case 3:
			season = "장미";
			break;

		default:
			season = "예외";
			}

	}

}
