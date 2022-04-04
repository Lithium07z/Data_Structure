import java.util.Comparator;

public class WithDate implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		if (b1.getYear() - b2.getYear() == 0) {
			if (b1.getMonth() - b2.getMonth() == 0) {
				if (b1.getDay() - b2.getDay() == 0) {
					return 0;
				} else {
					return b1.getDay() - b2.getDay();
				}
			} else {
				return b1.getMonth() - b2.getMonth();
			}
		}
		return b1.getYear() - b2.getYear();
	}
}
