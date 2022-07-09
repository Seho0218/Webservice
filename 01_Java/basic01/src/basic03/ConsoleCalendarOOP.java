package basic03;

import java.util.*;

public class ConsoleCalendarOOP {
	
	Scanner scan = new Scanner(System.in);
	Calendar date = Calendar.getInstance();
	
	ConsoleCalendarOOP(){
		
	}
	
	void titlePrint( int year, int month) {
		
	}
	
	
	int getWeek(int year, int month) {
		date.set(year,month-1,1);
		return date.get(Calendar.DAY_OF_MONTH);
	}
	
	void spacePrint(int week)
	{
		for(int i = 1;i<week;i++) {
			System.out.print("\t");
		}
	}
	
	int inData(String msg) {
		System.out.print(msg+" ->");
		return scan.nextInt();
	}
	
	void dayPrint(int week ,int lastDay)
	{
		for(int d = 1;d<=lastDay; d++) {
			System.out.print(d+"\t");
			if((d+week-1)%7==0) System.out.println();
		}
	}
	
	
	
	

	void startCalendar() {
		
		int year = inData("년도");
		int month = inData("월");
		
		titlePrint(year, month);
		
		//요일 구하기
		int week = getWeek(year, month);
		//공백처리
		spacePrint(week);
		
		int lastDay = date.getActualMaximum(Calendar.DATE);
		
		dayPrint(week, lastDay);
	}
	

}
