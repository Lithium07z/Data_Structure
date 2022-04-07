
public class Main {
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>();
		ArrayStack<String> stack2 = new ArrayStack<String>();
		
		String str1 = "(ant+bee)*crab+{[ant*food]+(offset)}/gas";
		System.out.println(str1 + " : " + stack.checkParentheses(str1));
		String str2 = "(ant+bee)*crab+[ant*food]+(offset)}/gas"; 
		System.out.println(str2 + " : " + stack.checkParentheses(str2));
		
		String s1 = "redivider";
		System.out.println(s1 + " : " + stack.checkPalindrome(s1));
		String s2 = "redder";
		System.out.println(s2 + " : " + stack.checkPalindrome(s2));
		String s3 = "a";
		System.out.println(s3 + " : " + stack.checkPalindrome(s3));
		String s4 = "abbd"; 
		System.out.println(s4 + " : " + stack.checkPalindrome(s4));
		String s5 = "abcde"; 
		System.out.println(s5 + " : " + stack.checkPalindrome(s5));
	}
}
