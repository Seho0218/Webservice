package 문제;

import java.lang.*;
import java.util.*;

public class money {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int oman=0,man=0,ocheon=0,cheon=0,
				obaek=0, baek=0,sip=0, o=0; 
		Scanner scan = new Scanner(System.in);
		
		
		do {
		System.out.print("금액 입력 = ");
		
		int money = scan.nextInt();
		
		
		
		
		oman = money/50000;
		money = money%50000;
		System.out.printf("50000원= %d장\n",oman);
		
		man = money/10000;
		money = money%10000;
		System.out.printf("10000원= %d장\n",man);
		
		ocheon = money/5000;
		money = money%5000;
		System.out.printf("5000원= %d장\n",ocheon);
		
		cheon = money/1000;
		money = money%1000;
		System.out.printf("1000원= %d장\n",cheon);
		
		obaek = money/500;
		money = money%500;
		System.out.printf("500원= %d개\n",obaek);
		
		baek = money/100;
		money = money%100;
		System.out.printf("100원= %d개\n",baek);
		
		sip = money/10;
		money = money%10;
		System.out.printf("10원= %d개\n",sip);
		
		o = money/5;
		money = money%5;
		System.out.printf("5원= %d개\n",o);}
		while(true);
		
		
		}

	}


