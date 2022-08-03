package homework;

import java.lang.*;
import java.util.*;


public class ForEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int tot=0,tote = 0,toto=0;
		
		System.out.print("������ ���� =  ");
		int num = scan.nextInt(); 
		
		for(int i= 1; i<=num; i++) {
				tot+=i;
			if(i%2==1)
				toto+=i;
			if(i%2==0)
				tote+=i;				
		}
		
	
		
		System.out.printf("1~ %d ������ ����? %d \n",num,tot);
		System.out.printf("1~ %d ������ Ȧ���� ����? %d \n",num,toto);
		System.out.printf("1~ %d ������ ¦���� ����? %d \n",num,tote);


	}

}
