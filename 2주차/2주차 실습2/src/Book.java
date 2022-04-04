import java.util.Comparator;

public class Book implements Comparable<Book>{
	private String title;
	private int serial;
	private int year;
	private int month;
	private int day;
	
	Book(String title, int serial, int year, int month, int day) {
		this.title = title; this.serial = serial; this.year = year; this.month = month; this.day = day;
	}
	
	public static final Comparator<Book> With_Name = new WithName();
	public static final Comparator<Book> With_Serial = new WithSerial();
	public static final Comparator<Book> With_Date = new WithDate();
	
	public String getTitle() {
		return this.title;
	}
	public int getSerial() {
		return this.serial;
	}
	public int getYear() {
		return this.year;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	
	@Override
	public int compareTo(Book b1) {
		return this.title.compareTo(b1.getTitle());
	}
	public String toString() {
		return "도서명 : " + this.title + " 고유 번호 : " + this.serial + " 출간(년) : " + this.year + 
				" 출간(월) : " + this.month + " 출간(일) : " + this.day;
	}
}
