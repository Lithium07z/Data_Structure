import java.util.Scanner;

public class TestFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���丮�� N�� ���� �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		FactorialLoop fl = new FactorialLoop();
		fl.loop(num1);
		
		System.out.print("���丮�� N�� ���� �Է��ϼ��� : ");
		int num2 = sc.nextInt();
		FactorialRecursive fr = new FactorialRecursive();
		fr.recursive(num2);
	}
}

