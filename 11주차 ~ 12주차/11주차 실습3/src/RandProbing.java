import java.util.Random;

public class RandProbing<K, V> {
	private int N = 0, M = 13; // 테이블에 저장된 항목 수, 테이블 크기 < 항상 소수로 설정해야 함 
	private K[] a = (K[]) new Object[M]; // key 값을 저장하는 테이블 / Key값을 해쉬값으로 바꿔야 하니까
	private V[] d = (V[]) new Object[M]; // value 값을 저장하는 테이블

	private int hash(K key) { // 해쉬코드
		return (key.hashCode() & 0x7fffffff) % M; // 나머지 연산
		// 0x7fffffff = 011111.... < And 연산이므로 첫 번째 sign값만 0으로 바뀜 = 양수로 됨
	}
	
	public void put(K key, V data) {
		int initialpos = hash(key);
		int i = initialpos;
		Random rand = new Random(); // 랜덤함수 호출
		rand.setSeed(10); // 랜덤함수의 시드숫자를 10으로 설정
		do {
			if (a[i] == null) {
				a[i] = key;
				d[i] = data;
				N++; // 항목 수 증가 
				return;
			}
			if (a[i].equals(key)) {
				d[i] = data;
				return;
			}
			i = (initialpos + rand.nextInt(1000)) % M; // 랜덤함수를 이용해서 다음 위치 계산
		} while (N < M); // 실제 아이템 갯수가 테이블 크기보다 작을때까지만
	}
	public V get(K key) {
		Random rand = new Random(); // 랜덤함수 호출
		rand.setSeed(10); // 랜덤함수의 시드숫자를 10으로 설정
		int initialpos = hash(key);
		int i = initialpos;
		while (a[i] != null) {
			if (a[i].equals(key)) { // 탐색성공
				return d[i];
			}
			i = (initialpos + rand.nextInt(1000)) % M; // 랜덤함수를 이용해서 다음 위치 계산
		}
		return null; // 탐색 실패
	}
	
	public void print() {
		System.out.println("해시 테이블 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + i);
		}
		System.out.println();
		for (int i = 0; i < d.length; i++) {
			System.out.print("\t" + a[i]);
		}
		System.out.println();
	}
}
