import java.util.Arrays;

public class Libraray {
	public static void main(String[] args) {
		Book[] bk = {
				new Book("�Ѹ����б�", 1, 2010, 3, 15), new Book("IT ���", 2, 2018, 8, 11),
				new Book("�ڹ� ���α׷���", 3, 2011, 1, 1), new Book("C ���α׷���", 4, 1999, 12, 18),
				new Book("�ΰ�����", 5, 2019, 2, 22), new Book("����н�", 6, 2015, 9, 30),
				new Book("�ΰ��� �̷�", 7, 2017, 5, 21)
		};
		
		Arrays.sort(bk);
		print(bk);
		Arrays.sort(bk, Book.With_Name);
		print(bk);
		Arrays.sort(bk, Book.With_Serial);
		print(bk);
		Arrays.sort(bk, Book.With_Date);
		print(bk);
	}
	public static void print(Book[] bk) {
		for (Book value : bk) {
			System.out.println(value.toString());
		}	
		System.out.println("--------------------------------------------------------------------");
	}
}
