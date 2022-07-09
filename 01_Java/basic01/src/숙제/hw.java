package 숙제;

import java.lang.*;
import java.util.*;

public class hw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar now = Calendar.getInstance(); // 오늘 날짜와 시간
		Scanner scan = new Scanner(System.in);
	
		
		System.out.print("년도 = ");
		int year = scan.nextInt();
		
		System.out.print("월 = ");		
		int month = scan.nextInt();
		
		System.out.println("\t\t\t\t\t"  +year+  "년  " +month +"월\n");
		System.out.println("일\t\t월\t\t화\t\t수\t\t목\t\t금\t\t토");
		
		
		
		now.set(Calendar.YEAR,year);
		now.set(Calendar.MONTH,month);
		now.set(year, month-1,1);

		
		int eod = now.getActualMaximum(Calendar.DAY_OF_MONTH); // 마지막날 구하기 DATE 가능
		int DOW = now.get(Calendar.DAY_OF_WEEK); // 요일 구하기
		
		
		for(int A=1; A<=eod; A++) {
			if(A==1) {
				for(int j=1; j<DOW; j++) {
					System.out.print("\t\t");
				}
			}
			if(A<10) {
				System.out.print(" ");
			}
			System.out.print(""+A+"\t\t");
			if(DOW%7==0) {
				System.out.println();
			}
			DOW++;
		}

		System.out.println(now);
		scan.close();
		now.clone();
		
		
		/*firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,{YEAR=2022,MONTH=5},WEEK_OF_YEAR=23,WEEK_OF_MONTH=1,
		 * DAY_OF_MONTH=1,DAY_OF_YEAR=152,{DAY_OF_WEEK=4},DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=4,HOUR_OF_DAY=4
		 * MINUTE=2,SECOND=40,MILLISECOND=186,ZONE_OFFSET=32400000,DST_OFFSET=0]
		now.set(Calendar.MONTH,month);
		 * 
		 * 
		 * HOUR_OF_DAY=0,MINUTE=20,SECOND=7,MILLISECOND=776,ZONE_OFFSET=32400000*/
		
		
	}

}
