import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value;
		
		System.out.print("1보다 큰 양의 정수를 입력하세요 : ");
		value = sc.nextInt();
		for (int i = 2; i <= value - 1; i++) {
			if (value % i == 0) {
				System.out.println(value + "은(는) 소수가 아닙니다.");
				System.exit(0);
			}
		}	
		System.out.println(value + "은(는) 소수 입니다.");
	}
}
