package again;

import java.lang.*;
import java.util.*;

public class ForEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1; i<=5 ; i++) 
		
		{
			for(int j = 1; j<=i ; j++)
			{
				System.out.printf("%d",j);
			}
			
			System.out.println(" ");
		}
		
	

			for(int r=1; r<=5 ; r++) 			
			{
				for(int s = 1; s<=5-r ; s++)
				{					
					System.out.print("  ");					
				}
				
				for(int c = 1; c<=r ; c++) {
				
					System.out.printf("*");						
			}
								
					System.out.println();				
			}
			
/*				
		
			for(int i=1; i<5 ; i++){
					
				for(int j = 0; j<=i ; j++) 
				{
					System.out.printf("-");						
				}	
				
				
				for(int j = 0; j<=5-i ; j++)
				{					
					System.out.printf("*");					
				}
					System.out.println();				
				}		
			}*/
	}
			
	}

