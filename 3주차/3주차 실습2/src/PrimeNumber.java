import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value;
		
		System.out.print("1���� ū ���� ������ �Է��ϼ��� : ");
		value = sc.nextInt();
		for (int i = 2; i <= value - 1; i++) {
			if (value % i == 0) {
				System.out.println(value + "��(��) �Ҽ��� �ƴմϴ�.");
				System.exit(0);
			}
		}	
		System.out.println(value + "��(��) �Ҽ� �Դϴ�.");
	}
}
