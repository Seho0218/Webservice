package basic01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		do {
			
			System.out.printf("���� �� = ");
			int cnt = scan.nextInt();
			
			
			
			for(int i = 1; i<=cnt; i++) {	
				int lotto[] = new int[7];
				
						for(int j = 0; j<lotto.length;j++) {
							
						
							lotto[j]=random.nextInt(45)+1;
							
							for(int c = 0; c<j; c++) {
								
								if(lotto[c]==lotto[j]) {
									j--;
									break;
									
								}
									
							}
						}
						Arrays.sort(lotto,0,6);
						System.out.println(i+"����="+ Arrays.toString(Arrays.copyOfRange(lotto, 0, 6))+", bonus = " +lotto[6]);
			
			}
			System.out.print("����Ͻðڽ��ϱ� (1:��, 2:�ƴϿ�)?");	
			int qna = scan.nextInt();
			
			if(qna!=1)break;
			
		}while(true);
	}

}
