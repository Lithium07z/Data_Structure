
public class Main {
	public static void main(String[] args) {
		Chaining<Integer, Integer> ch = new Chaining<Integer, Integer>();

		int[] arr1 = { 1, 2, 3, 9 };
		int[] arr2 = { 1, 2, 4, 4 };
		int sum1 = 8;
		int sum2 = 8;
		
		//System.out.println("결과 : " + ch.findTwoNum(arr1, sum1));
		System.out.println("결과 : " + ch.findTwoNum(arr2, sum2));
	}
}
