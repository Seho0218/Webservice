package api;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
					//String : 연산이 적은 데이터 스레드 기능
					//StringBuffer : 연산이 많고 스레드(동기화) 가능
					// StringBuffer : 연산이 많고 동기화를 고려하지 않음.
		
		StringBuffer sb = new StringBuffer("JAVA Programming Test...");
		//확보한 메모리 확인
		System.out.println("capacity ->" + sb.capacity());
		sb.append("확인");
		sb.insert(4, "(자바)");
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		//확보한 메모리 확인
		
		StringBuffer first = new StringBuffer("Java");
		StringBuffer second = new StringBuffer("JAVA");
		
		int result = first.compareTo(second);
		int result2 = second.compareTo(first);
		
		System.out.println("result->"+ result+ " result2 ->"+ result2);
		//양수 왼쪽이크다, 음수 오른쪽이 크다 0 은 같다 첫글자만 비교 같으면 넘어감

	}

}
