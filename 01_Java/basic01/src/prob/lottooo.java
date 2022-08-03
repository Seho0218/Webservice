package prob;

import java.util.*;


public class lottooo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int game=0;
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		TreeSet<Integer> ms = new TreeSet<Integer>();
		
		Iterator<Integer> p=ms.iterator();
		
			 
	do {	
			System.out.printf("���� �� = ");
			game = scan.nextInt();
						
			for(int k = 1; k<=game; k++) {			
				int rand[] = new int[7];
				
				for(int i = 0 ; i<rand.length ; i++) {
					rand[i]= random.nextInt(45)+1;
					
					for(int u : rand[i]) {
						ms.add(u);
					}			
				}
				while(p.hasNext()) {
					int d = p.next();
					System.out.print(d);
				}
				
			}
				System.out.print("����Ͻðڽ��ϱ� (1:��, 2:�ƴϿ�)?");	
				int m = scan.nextInt();
				
				if(m!=1)
					break;
			
		}while(true);
	
	}
		
}



