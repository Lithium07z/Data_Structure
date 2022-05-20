
public class QuadProbing<K, V> {
	private int N = 0, M = 13; // 테이블에 저장된 항목 수, 테이블 크기 < 항상 소수로 설정해야 함 
	private K[] a = (K[]) new Object[M]; // key 값을 저장하는 테이블 / Key값을 해쉬값으로 바꿔야 하니까
	private V[] d = (V[]) new Object[M]; // value 값을 저장하는 테이블
	private int hash(K key) { // 해쉬코드
		return (key.hashCode() & 0x7fffffff) % M; // 나머지 연산
		// 0x7fffffff = 011111.... < And 연산이므로 첫 번째 sign값만 0으로 바뀜 = 양수로 됨
	}
	
	public void put(K key, V data) { 
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if (a[i] == null) { // 삽입 위치 발견
				a[i] = key; // key를 해쉬테이블에 저장 
				d[i] = data; N++; // key관련 데이터 저장 
				return;
			}
			if (a[i].equals(key)) { // 이미 key 존재
				d[i] = data; // data 데이터만 갱신 
				return;
			}
			i = (initialpos + j * j++) % M; // 점프 크기가 제곱 크기로 증가함 
		} while (N < M);
	}
	
	public V get(K key) {
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) { // a[i]가 empty가 아니면
			if (a[i].equals(key)) { // 탐색 성공
				return d[i];
			}
			i = (initialpos + j * j++) % M; // 점프 크기가 제곱 크기로 증가함 
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