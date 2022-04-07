
public class Main {
	public static void main(String[] args) {
		ListStack<String> stack = new ListStack<String>();
		
		
		String s1 = "A*(B+C/D)";
		System.out.println(s1 + " : " + stack.getPostEq(s1));
		String s2 = "(A+B)*(C-D)";
		System.out.println(s2 + " : " + stack.getPostEq(s2));
		
		String[] s3 = {"8", "37", "13", "+", "40", "-", "*"};
		String[] s4 = {"20", "-10", "3", "+", "*"};
		System.out.println("[Task1]");
		for (String s : s3) {
			System.out.print(s + " ");
		}
		System.out.println("\n" + stack.calc(s3));
		System.out.println("[Task2]");
		for (String s : s4) {
			System.out.print(s + " ");
		}
		System.out.println("\n" + stack.calc(s4));
		
	}
}
