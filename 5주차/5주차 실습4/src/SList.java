import java.util.NoSuchElementException;

public class SList<E> {
	protected Node head; // 연결리스트의 첫 노드를 가리킴
	private int size;

	public SList() { // 연결리스트 생성자
		head = null;
		size = 0;
	}

	public int search(int target) { // target값을 탐색
		Node p = head;
		for (int k = 0; k < size; k++) {
			if (target == p.getItem()) { // p 노드의 item과 target이 일치하면
				return k; // 해당위치 반환
			}
			p = p.getNext();
		}
		return -1; // 탐색 실패시 -1 반환
	}

	public void insertFront(int newItem) { // 연결리스트 맨 앞에 새 노드 삽입
		head = new Node(newItem, head); // 추가하려는 새 item값과 head가 가리키는 주소를 가지는 새로운 헤드 생성
		size++; // 값 추가되었으니 사이즈 증가
	}

	public void insertAfter(int newItem, Node p) { // 노드 p 바로 다음에 새 노드 삽입
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
		} else {
		} // p.next인 t가 null이면, 아무것도 할게 없음
	}

	public int size() {
		return this.size;
	}

	public void setAndOrderNodes(int[] arr) {
		int value = this.size;
		if (arr != null) {
			for (int i = 0; i < value; i++) {
				deleteFront();
			}
		} else {
			return;
		}

		Loop: for (int i = 0; i < arr.length; i++) {
			Node next = head; // 맨 처음에 헤드값 넣는 노드
			Node before = null; // next노드 전 순번 노드 기억하려는 노드
			if (size == 0) { // 아무것도 없으면
				insertFront(arr[0]); // 배열 첫 번째값 일단 넣기
			} else { // 리스트에 뭔가 들어있으면 시작
				if (head.getItem() >= arr[i]) { // 헤드 값이 arr[i]보다 크거나 같으면
					insertFront(arr[i]); // arr[i]를 맨 앞에 넣어서 헤드로 만듬
					continue; // 끝났으니 아래 코드 무시하고 복귀
				}
				for (int k = 0; k < size; k++) { // 사이즈 만큼 반복 
					if (next.getItem() > arr[i]) { // next값이 arr[i]보다 크면
						insertAfter(arr[i], before); // next전에 arr[i]추가
						continue Loop; // Loop로 탈출
					}
					if (next.getNext() != null) { // next다음이 null이 아닐때만
						before = next; // before에 지금 값 넣고
						next = next.getNext(); // next에 다음값 받음 이러면 before는 항상 next전이고 한 칸씩 이동하면서 검사
					}
				}
				insertAfter(arr[i], next); // 리스트 마지막값 보다 크면 추가
			} // 레전드 메소드 와 이거 만든다고 지호랑 5시간동안 머리 굴림
		}
	}

	public void reverse() {
		int arr[] = new int[this.size]; // 기존 값 저장 할 배열
		int value = this.size; // 원래 크기 기억하는 변수
		Node loop = head; // 시작할 노드 
		for (int i = 0; i < this.size; i++) {
			arr[i] = loop.getItem(); // 노드 값 배열에 넣고
			loop = loop.getNext(); // 다음 노드로 가기
		}
		for (int i = 0; i < value; i++) { // 원래 들어있던 값 다 밀어버리기
			deleteFront();
		}
		for (int i = 0; i < value; i++) { // 어짜피 앞부터 추가하면 뒤로 밀리면서 역순됨 
			insertFront(arr[i]);
		}
 	}

	public void join(SList slist2) {
		int arr[] = new int[size + slist2.size]; // 두 리스트 사이즈 만큼의 길이만큼의 배열 생성 
		Node value1 = this.head; // 기본이 되는 리스트의 head 노드를 value1에 넣기
		Node value2 = slist2.head; // 합치려고 넣은 리스트의 head 노드를 value2에 넣기
		for (int m = 0; m < this.size + slist2.size; m++) { // 두 리스트 사이즈 만큼의 배열 길이만큼 반복 
			if (m < this.size) { // 기준이 되는 리스트 사이즈만큼은 기준이 되는 리스트의 노드 값을 넣고
				arr[m] = value1.getItem(); 
				value1 = value1.getNext(); // 헤드 다음으로 계속 넘기기 
			} else { // 그 다음부턴 합치려고 넣은 리스트 노드 값 넣기 
				arr[m] = value2.getItem();
				value2 = value2.getNext(); // 헤드 다음으로 계속 넘기기
			}
		}
		setAndOrderNodes(arr); // 완성된 배열은 setAndOrderNodes가 정리해줌
	}

	public void print() {
		Node out = this.head;
		for (int i = 0; i < this.size; i++) {
			System.out.print(out.getItem() + " ");
			out = out.getNext();
		}
		System.out.println();
	}
}