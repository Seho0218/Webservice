package api;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
					//String : ������ ���� ������ ������ ���
					//StringBuffer : ������ ���� ������(����ȭ) ����
					// StringBuffer : ������ ���� ����ȭ�� ������� ����.
		
		StringBuffer sb = new StringBuffer("JAVA Programming Test...");
		//Ȯ���� �޸� Ȯ��
		System.out.println("capacity ->" + sb.capacity());
		sb.append("Ȯ��");
		sb.insert(4, "(�ڹ�)");
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		//Ȯ���� �޸� Ȯ��
		
		StringBuffer first = new StringBuffer("Java");
		StringBuffer second = new StringBuffer("JAVA");
		
		int result = first.compareTo(second);
		int result2 = second.compareTo(first);
		
		System.out.println("result->"+ result+ " result2 ->"+ result2);
		//��� ������ũ��, ���� �������� ũ�� 0 �� ���� ù���ڸ� �� ������ �Ѿ

	}

}
