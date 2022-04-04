
public class TimeCheck {
	public static void main(String[] args) {
		int[] arr = new int[90000]; // create an array
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0; // initialize
		
		long beforeTime = System.currentTimeMillis(); // start the timer
		fCubic(arr); // wait until it returns
		long afterTime = System.currentTimeMillis(); // finish the timer
		
		long diffTimeMilliSecond = afterTime - beforeTime; // get the diff
		System.out.println("Time diff (ms): " + diffTimeMilliSecond);

	}

	public static int fConstant(int[] arr) {
		return arr.length * 2;
	}
	public static int fLinear(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum; 
	}
	public static int fQuadratic(int[] arr) {
		int value = 179999;
		for (int j = 0; j < arr.length; j++) {
			for (int k = 0; k < arr.length; k++) {
				if (j + k == value) {
					return value;
				}
			}
		}
		return value;
	}
	public static int fCubic(int[] arr) {
		int value = 179999;
		for (int j = 0; j < arr.length; j++) {
			for (int k = 0; k < arr.length; k++) {
				for (int l = 0; l < arr.length; l++) {
					if (j + k + l == value) {
						return value;
					}
				}
			}
		}
		return value;
	}
	public static int fFourth(int[] arr) {
		int value = 179999;
		for (int j = 0; j < arr.length; j++) {
			for (int k = 0; k < arr.length; k++) {
				for (int l = 0; l < arr.length; l++) {
					for (int m = 0; m < arr.length; m++) {
						if (j + k + l + m == value) {
							return value;
						}
					}
				}
			}
		}
		return value;
	}
}
