package 숙제;

import java.util.*;
public class diamond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner scan = new Scanner(System.in);	
	
	int num=0;
	char al = 'A';
	     //	A = 65 Z= 90
	
	
		
	System.out.printf("임의의 홀수 입력(1~49) : ");
	num = scan.nextInt();
		
	if(num>0 && num<50 && num%2 !=0)	
	{
		int i = 0;
		for(i = 0 ; i<num ; i++) {
			
			char A = (char)(al+i);
			
			A =	(char) (A >90 ?  (char)(al+) : A);
			
				System.out.println(A);
				
				
			
		
		}
		
		
		
			
		
	}
	else{	
			System.out.printf("에러");
		}		
           		
	}     

}
