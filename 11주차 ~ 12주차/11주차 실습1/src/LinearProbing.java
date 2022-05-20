
public class LinearProbing<K, V> {
	private int M = 13; // 테이블 크기, 항상 소수로 설정해야 함 
	private K[] a = (K[]) new Object[M]; // key 값을 저장하는 테이블 / Key값을 해쉬값으로 바꿔야 하니까
	private V[] d = (V[]) new Object[M]; // value 값을 저장하는 테이블
	private int hash(K key) { // 해쉬코드
		return (key.hashCode() & 0x7fffffff) % M; // 나머지 연산
		// 0x7fffffff = 011111.... < And 연산이므로 첫 번째 sign값만 0으로 바뀜 = 양수로 됨
	}
	
	public void put(K key, V data) { // 삽입연산
		int initialpos = hash(key); // key값으로 hash코드 추출
		int i = initialpos, j = 1;
		do {
			if (a[i] == null) { // null = 비었음 = 삽입할 위치 
				a[i] = key; // key를 해쉬테이블에 저장
				d[i] = data; // key관련 데이터를 동일한 인덱스에 저장
				return;
			}
			if (a[i].equals(key)) { // key가 같아서 hash코드가 같은 경우
				d[i] = data; // 데이터만 갱신, 덮어씌움
				return;
			}
			i = (initialpos + j++) % M; // key는 다르지만 hash코드가 우연히 같은 경우 
			// j번째, 다음 위치로 이동후 배열 크기(소수)로 나눔
		} while(i != initialpos); // i가 initialpos와 같다 = 초기위치까지 돌아왔으나 저장할 공간이 없었다.
		// 계속 넣을 공간을 못찾으면 j가 증가해서 M과 같아짐, 따라서 나눈 값이 i와 같아지고 반복문 탈출 
	}
	
	public V get(K key) { // 탐색 연산 
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key)) { // 찾는 키랑 동일하면
				return d[i]; // 해당 값 리턴 
			}
			i = (initialpos + j++) % M; 
		} while (a[i] != null && i != initialpos);
		// a[i] == null이면 stop < 못찾음, i == initialpos로 처음위치로 돌아오면 stop < 못찾음
		return null;
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


