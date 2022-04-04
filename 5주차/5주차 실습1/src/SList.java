import java.util.NoSuchElementException;

public class SList<E> {
	protected Node head; // 연결리스트의 첫 노드를 가리킴
	private int size;

	public SList() { // 연결리스트 생성자
		head = null;
		size = 0;
	}

	public int search(E target) { // target값을 탐색
		Node p = head;
		for (int k = 0; k < size; k++) {
			if (target == p.getItem()) { // p 노드의 item과 target이 일치하면
				return k; // 해당위치 반환
			}
			p = p.getNext();
		}
		return -1; // 탐색 실패시 -1 반환
	}

	public void insertFront(E newItem) { // 연결리스트 맨 앞에 새 노드 삽입
		head = new Node(newItem, head); // 추가하려는 새 item값과 head가 가리키는 주소를 가지는 새로운 헤드 생성
		size++; // 값 추가되었으니 사이즈 증가
	}

	public void insertAfter(E newItem, Node p) { // 노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node(newItem, p.getNext()));
		// 추가하려는 새 값과 기존에 p가 가리키던 주소를 가지는 새 노드를 생성 후 p.가 새로 만들어진 노드와 연결되게 함
		size++;
	}

	public void deleteFront() {
		if (size == 0) {
			throw new NoSuchElementException(); // 사이즈가 0이라 지울게 없으면 Exception 던지기
		}
		head = head.getNext();
		size--;
	}

	public void deleteAfter(Node p) { // p가 가르키는 노드의 다음 노드를 삭제
		if (p == null) {
			throw new NoSuchElementException(); // p가 마지막 노드라 다음 노드가 없을 때
		}
		Node t = p.getNext(); // 노드 t에 p의 다음 노드를 넣음 
		if (t != null) { // p 다음에 유효한 노드가 있는 경우
			p.setNext(t.getNext()); 
			// 노드t의 다음 노드를 p의 다음 노드로 설정함 결국 p의 다다음 노드가 p다음 노드를 삭제한 뒤 링크될 노드이므로 이렇게 됨 
			t.setNext(null); // 노드t를 참조하는 링크가 없지만 노드t는 p에 참조할 수도 있으니 null값을 넣음으로서 차단 
			size--; // 삭제했으니 사이즈 감소 
		} else {} // p.next인 t가 null이면, 아무것도 할게 없음 
	}
	
	public int size() {
		return this.size;
	}
	
	public void print() {
		Node out = this.head;
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
	}
}
