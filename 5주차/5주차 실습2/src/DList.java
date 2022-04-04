import java.util.NoSuchElementException;

public class DList <E> {
	protected DNode head, tail; // 노드의 시작과 끝 값 
	protected int size;

	public DList() { // 이중 연결리스트 생성자
		head = new DNode (null, null, null); // Dummy 노드
		tail = new DNode (null, head, null); // tail의 이전 노드를 head로 만든다 
		head.setNext(tail); // head의 다음 노드를 tail로 만든다 
		size = 0;
	}

	public void insertBefore(DNode p, E newItem) { // p가 가리키는 이전 노드 t앞에 삽입
		DNode t = p.getPrevious(); // p의 이전 노드를 t에 넣음 
		DNode newNode = new DNode(newItem, t, p); // 뒤로는 t 앞으로는 p를 가리키는 새로운 newNode를 만듬  
		p.setPrevious(newNode); // p의 뒤쪽 링크에 newNode가 연결됨  
		t.setNext(newNode); // t의 앞쪽 링크에 newNode가 연결됨 결국 t - newNode - p 의 형태
		size++; // 추가했으니 사이즈 증가 
	}
	
	public void insertAfter(DNode p, E newItem) { // p가 가리키는 다음 노드 t뒤에 삽입
		DNode t = p.getNext(); // p의 다음 노드를 t에 넣음
		DNode newNode = new DNode(newItem, p, t); // 뒤로는 p 앞으로는 t를 가리키는 새로운 newNode를 만듬
		t.setPrevious(newNode); // t의 뒤쪽 링크에 newNode가 연결됨
		p.setNext(newNode); // p의 앞쪽 링크에 newNode가 연결된 결국  p - newNode - t 의 형태
		size++; // 추가했으니 사이즈 증가 
	}
	
	public void delete(DNode x) { // x가 가르키는 노드 삭제
		if (x == null ) { // x노드가 없다면 Exception 던지기 
			throw new NoSuchElementException();
		}
		if (size <= 0) { // 노드가 없거나 음수인 경우 Exception 던지기
			throw new NoSuchElementException();
		}
		DNode f = x.getPrevious(); // f노드에 x노드의 이전 값 저장
		DNode r = x.getNext(); // r노드에 x노드의 다음 값 저장 
		f.setNext(r); // f노드의 다음 값을 r노드로 세팅
		r.setPrevious(f); // r노드의 이전 값을 f 노드로 세팅 
		size--; // 삭제했으니 사이즈 감소 사실 실질적으로 데이터 삭제가 아닌 x노드에 참조할 수 있는 링크를 모두 없애버린 것임
	}
	
	public void print() {
		DNode out = this.head.getNext();
		if (out.getNext() == null) { // head노드 다음이 null이면 
			System.out.println("리스트 비어있음");
		}
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
		System.out.println();
	}
}
