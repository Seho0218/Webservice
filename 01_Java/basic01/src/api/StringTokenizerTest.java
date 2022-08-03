package api;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String colorName = "Red?Blue-Green,Cyan,?,yellow/brown" ;		
		StringTokenizer st  = new StringTokenizer(colorName, ",.- /?");

	}

}
