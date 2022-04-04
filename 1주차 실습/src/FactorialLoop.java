import java.util.Scanner;

public class FactorialLoop {
 	public void loop(int num) {
		int sum = 1;
		for (int i = num; i > 0; i--) {
			sum *= i;
		}
		System.out.println(sum);
	}
}
