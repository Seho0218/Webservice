package again;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {56,84,61,15,3,78,8,79,42};
		int amp = 0; 
		
		for(int j = 0; j<arr.length-j;j++) {
			
			for(int i = 0; i<arr.length-1;i++){			
				if(arr[i]>arr[i+1]) {
					
					amp = arr[i];			
					arr[i]=arr[i+1];
					arr[i+1]=amp;
				}			
			}
			for(int i = 0; i<arr.length;i++)
				System.out.print(arr[i]  + "\t");
			
			}
			System.out.println();
		}	
	}

