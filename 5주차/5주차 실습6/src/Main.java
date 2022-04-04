
public class Main {
	public static void main(String[] args) {
		CList<String> cl1 = new CList<String>(); // 환형리스트 객체 cl 생성
		CList<String> cl2 = new CList<String>(); // 환형리스트 객체 cl 생성
		
		for (int i = 4; i > 0; i--) {
			cl1.insert(i);
			cl2.insert(i);
		}
		
		System.out.println("[CListTask1]");
		cl1.print();
		System.out.println();
		cl2.print();
		
		System.out.println();
		System.out.println("[CListTask2]");
		cl1.rotateLeft(1); 
		cl2.rotateRight(1); 
		
		System.out.println("[CListTask3]");
		cl1.print();
		System.out.println();
		cl2.print();
	}
}
