import java.util.Arrays;

public class Libraray {
	public static void main(String[] args) {
		Book[] bk = {
				new Book("한림대학교", 1, 2010, 3, 15), new Book("IT 기술", 2, 2018, 8, 11),
				new Book("자바 프로그래밍", 3, 2011, 1, 1), new Book("C 프로그래밍", 4, 1999, 12, 18),
				new Book("인공지능", 5, 2019, 2, 22), new Book("기계학습", 6, 2015, 9, 30),
				new Book("인간의 미래", 7, 2017, 5, 21)
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
