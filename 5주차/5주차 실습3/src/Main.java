
public class Main {
	public static void main(String[] args) {
		CList<String> s = new CList<String>(); // ȯ������Ʈ ��ü s ����
		
		s.insert("pear"); s.insert("cherry");
		s.insert("orange"); s.insert("apple");
		s.print();
		System.out.println(": s�� ���� = " + s.size() + "\n");
		
		s.delete();
		s.print();
		System.out.println(": s�� ���� = " + s.size()); System.out.println();
	}
}
