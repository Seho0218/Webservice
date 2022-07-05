package 다시볼것;

import java.util.*;


class Solution {
    public String solution(int num) {
        
        if(num%2==0){
            String answer = "Even";
            return answer;
        }else {
            
        String answer = "Odd";
        return answer; 
    }}
}

public class Array01 {

	public static void main(String[] args) {
        int num = 0;
        Scanner scan = new Scanner(System.in);
        Solution sol = new Solution();
        
        System.out.printf("정수 입력");
        num = scan.nextInt();
        
        sol.solution(num);
        System.out.printf( sol.solution(num));
    }
               
}


