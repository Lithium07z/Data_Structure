
public class Chaining<K, V> {
	private int M = 13; // 테이블 크기
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

		public Object getkey() {
			return key;
		}

		public Object getData() {
			return data;
		}
	} // end of Noed class

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
	}// 처음 해쉬테이블을 만들 때 이미 null값으로 내부가 다 초기화되어 있어서 null값을 따로 안넣어줘도 됨
	 // 맨 처음 노드는 next가 null일거고 값이 추가되면서 계속 뒤로 밀림
	
	public boolean findTwoNum(int[] arr, int sum) {
		for (int i = 0; i < a.length; i++) { // 시작 전 해쉬테이블 초기화 
			a[i] = null;
		}
		for (int z : arr) {
			K diff = (K)(Object)(sum - z); // sum - z 
			if (get(diff) != null) {
				return true;
			} else {
				put((K)(Object)z, (V)(Object)z);
			}
		}
		return false;
	}
	
	public void print() {
		System.out.println("해시 테이블 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(i);
			if (a[i] != null) {
				Node n = a[i];
				while (n != null) {
					System.out.print("-->[" + n.getkey() + ", " + n.getData() + "]");
					n = n.next;
				}
			}
			System.out.println();
		}
	}
}