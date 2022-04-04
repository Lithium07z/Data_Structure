public class FactorialRecursive {
	int sum = 1;
	
	public void recursive(int num) {
		if (num == 0 ) {
			System.out.println(sum);
			return;
		} else {
			sum *= num;
			recursive(num -1);
		}
	}
}
