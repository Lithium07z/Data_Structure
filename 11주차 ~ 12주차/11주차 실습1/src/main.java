
public class main {
	public static void main(String[] args) {
		LinearProbing LProbing = new LinearProbing();
		LinearProbing2<Integer, Integer> LProbing2 = new LinearProbing2<Integer, Integer>();
		
		LProbing.put(25, "grape");
		LProbing.put(37, "apple");
		LProbing.put(18, "banana");
		LProbing.put(55, "cherry");
		LProbing.put(22, "mango");
		LProbing.put(35, "lime");
		LProbing.put(50, "orange");
		LProbing.put(63, "watermelon");
		/*
		System.out.println("탐색 결과 : ");
		System.out.println(50 + "의 data = " + LProbing.get(50));
		System.out.println(63 + "의 data = " + LProbing.get(63));
		LProbing.print();
		*/
		LProbing2.put(25, 25);
		LProbing2.put(37, 37);
		LProbing2.put(18, 18);
		LProbing2.put(55, 55);
		LProbing2.put(22, 22);
		LProbing2.put(35, 35);
		LProbing2.put(50, 50);
		LProbing2.put(63, 63);
		
		LProbing2.print();
		System.out.println("63을 찾았습니다 : " + LProbing2.get(63));
		System.out.println("지워진 데이터 : " + LProbing2.delete(50));
		LProbing2.print();
		System.out.println("63을 찾았습니다 : " + LProbing2.get(63));
		
	}
}
