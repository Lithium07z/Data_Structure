
public class Chaining<K, V> {
	private int M = 5; // 테이블 크기
	private Node[] a = new Node[M]; // 해시 테이블

	public static class Node { // 노드 클래스를 내부 클래스로 정의해서 사용함
		public Object key;
		public Object data;
		public Node next;

		public Node(Object newkey, Object newdata, Node ref) { // 노드 클래스 생성자
			key = newkey;
			data = newdata;
			next = ref;
		}

		public Object getKey() {
			return key;
		}

		public Object getData() {
			return data;
		}
	} // end of Node class
	
	private int hash(K key) { // 해쉬코드
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public V get(K key) { // 탐색 연산
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) { // 연결리스트 탐색
			if (key.equals(x.key)) {
				return (V) x.data; // 탐색성공
			}
		}
		return null; // 탐색실패
	}

	public void put(K key, V data) { // 삽입 연산
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) {
			if (key.equals(x.key)) { // 이미 key가 존재함
				x.data = data; // 데이터 덮어씌워서 갱신
				return; // 종료
			}
		}
		a[i] = new Node(key, data, a[i]); // 연결 리스트의 첫 노드로 삽입 (head가 됨)
		check_and_rehash();
	}// 처음 해쉬테이블을 만들 때 이미 null값으로 내부가 다 초기화되어 있어서 null값을 따로 안넣어줘도 됨
	 // 맨 처음 노드는 next가 null일거고 값이 추가되면서 계속 뒤로 밀림

	private void check_and_rehash() {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				for (Node x = a[i]; x != null; x = x.next) {
					cnt++; // 테이블 내 실제로 존재하는 아이템 갯수
				}
			}
		}
		if ((double) cnt / (double) a.length > 0.75) {
			System.out.println("[check_and_rehash] 테이블의 사이즈를 " + a.length + " 에서 " + 2 * a.length + "로 변경합니다.");
			Node t[] = new Node[a.length * 2]; // 2배 크기의 테이블을 준비 
			M = a.length * 2;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != null) {
					t[hash((K) a[i].getKey())] = a[i];
				}
			}
			a = t;
			return;
		} else if ((double) cnt / (double) a.length < 0.25 && a.length / 2 >= 5) {
			System.out.println("[check_and_rehash] 테이블의 사이즈를 " + a.length + " 에서 " + a.length / 2 + "로 변경합니다.");
			Node t[] = new Node[a.length / 2]; // 1/2 크기의 테이블을 준비
			M = a.length / 2;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != null) {
					t[hash((K) a[i].getKey())] = a[i];
				}
			}
			a = t;
			return;
		}
		System.out.println("[check_and_rehash] 테이블의 사이즈를 변경하지 않습니다.");
	}

	public void delete(K key) {
		int hashVal = hash(key);
		if (a[hashVal].getKey().equals(key)) { 
			a[hashVal] = a[hashVal].next;
		}
		
		for (int i = 0; i < a.length; i++) {
			Node n = a[i];
			while (n != null) {
				Node t = n.next;
				if (t != null && t.getKey().equals(key)) {
					n.next = t.next;
					break;
				}
				n = n.next;
			}
		}
		check_and_rehash();
	}

	public void print() {
		System.out.println("해시 테이블 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(i);
			if (a[i] != null) { // a[i]의 값이 null이 아닌 경우만 
				Node n = a[i]; // a[i]의 노드를 n에 임시저장 
				while (n != null) { // n이 null이 아닐 때 까지만
					System.out.print("-->[" + n.getKey() + ", " + n.getData() + "]");
					n = n.next; // n의 다음 노드를 n에 넣음 
				}
			}
			System.out.println();
		}
	}
}