
public class DoubleHashing<K, V> {
	private int N = 0, M = 13; // 테이블에 저장된 항목 수, 테이블 크기 < 항상 소수로 설정해야 함 
	private K[] a = (K[]) new Object[M]; // key 값을 저장하는 테이블 / Key값을 해쉬값으로 바꿔야 하니까
	private V[] dt = (V[]) new Object[M]; // value 값을 저장하는 테이블

	private int hash(K key) { // 해쉬코드
		return (key.hashCode() & 0x7fffffff) % M; // 나머지 연산
		// 0x7fffffff = 011111.... < And 연산이므로 첫 번째 sign값만 0으로 바뀜 = 양수로 됨
	}
	
	public void put(K key, V data) {
		int initialpos = hash(key);
		int i = initialpos;
		int j = 1;
		int d = (7 - (int)key % 7); // 두 번째 해쉬함수, d = 7 - (int)key % 7
		do {
			if (a[i] == null) { // 삽입 위치
				a[i] = key; // key를 해쉬테이블에 저장
				dt[i] = data; // key 관련 데이터 저장 
				N++; // 항목수 증가 
				return;
			}
			if (a[i].equals(key)) { // 같은 key값 존재 
				dt[i] = data; // 데이터 덮어씌워서 갱신 
				return;
			}
			i = (initialpos + j * d) % M; // 두 번째 해쉬함수를 이용해서 군집화 방지
			j++;
		} while (N < M);
	}
	
	public V get(K key) {
		int initialpos = hash(key);
		int i = initialpos;
		int j = 1;
		int d = (7 - (int)key % 7); // 두 번째 해쉬함수, d = 7 - (int)key % 7
		while (a[i] != null) {
			if (a[i].equals(key)) {
				return dt[i];
			}
			i = (initialpos + j * d) % M; // 두 번째 해쉬함수를 이용해서 군집화 방지
			j++;
		}
		return null;
	}
	
	public void print() {
		System.out.println("해시 테이블 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print("\t" + i);
		}
		System.out.println();
		for (int i = 0; i < dt.length; i++) {
			System.out.print("\t" + a[i]);
		}
		System.out.println();
	}
}
