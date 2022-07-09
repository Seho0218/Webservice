package 숙제;

import java.lang.*;
import java.util.*;
import java.util.stream.*;


public class lotto2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int game=0;
	Scanner scan = new Scanner(System.in);
	Random random = new Random();
	
	
	do {	
		System.out.printf("게임 수 = ");
		game = scan.nextInt();
		
		for(int k = 1; k<=game; k++) {
						
			int rand[] = new int[7];
			
			for(int i = 0 ; i<rand.length ; i++) {
				rand[i]= random.nextInt(45)+1; 		
				
				for(int j = 0 ; j<i; j++) {
					if(rand[i]==rand[j]) {
						i--;		
						break;
					}
				}
			}
			Arrays.sort(rand,0,6);
			System.out.printf("%d게임"+Arrays.toString(Arrays.copyOfRange(rand, 0, 5))+", bonus =" +rand[6] +"\n",k);
			
			}
			
		
			System.out.print("계속하시겠습니까 (1:예, 2:아니오)?");	
			int o = scan.nextInt();
			
			if(o!=1)
				break;
		
	}while(true);
}

}





	


