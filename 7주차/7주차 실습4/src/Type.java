import java.util.NoSuchElementException;
import java.util.Stack;

public class Type<E> {
	Stack<Object> stk = new Stack<Object>();
	private E[] q; // 큐를 위한 배열
	private int front, rear, size;
	private int time = 0;

	public Type() { // 큐 생성자
		q = (E[]) new Object[2]; // 초기에 크기가 2인 배열 공간 하나는 비워야 하니까
		front = rear = size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void add(E newItem) { // 큐 삽입 연산
		if ((rear + 1) % q.length == front) { // 비어있는 원소가 1개 뿐인 경우(큐가 full인 경우 맨처음 비우는 한 칸을 제외한 모든칸이 꽉 찬)
			resize(2 * q.length);
		}
		rear = (rear + 1) % q.length;
		q[rear] = newItem;
		size++;
	}

	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException(); // 이미 비어있는 경우는 underflow방지로 프로그램 정지
		}
		front = (front + 1) % q.length;
		E item = q[front];
		q[front] = null;
		size--;
		if (size > 0 && size == q.length / 4) {
			resize(q.length / 2);
		}
		return item;
	}

	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for (int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j % q.length];
		}
		front = 0;
		rear = size;
		q = (E[]) t;
	}

	public int search(String type) {
		for (int i = front + 1; i < q.length; i++) {
			if (q[i] == null) { // null이면 스 equals 오류나니까
				continue; // 컨티뉴
			}
			if (q[i].equals(type)) { // 정상적인 데이터이면 Cat인지 비교
				return i - front; // 일치하면 위치 반환, front 기준으로 위치를 반환해야 함
			}
		}
		/*
		 * i에서 - front를 뻬면 front부터 i까지의 거리를 알 수 있고 이는 front에서 몇번 삭제해야 해당 위치인지 알 수 있게 됨
		 * search값을 받게 될 adoptAnimal메소드에서는 i가 0일 때부터 삭제를 시작하니 받은 값에서 -1을 할 것임 Ex)
		 * search에서 i - front가 2를 반환하면 adoptAnimal에서는 2번째 삭제시 해당 값을 버리면 됨 이때,
		 * adoptAnimal의 반복문은 0에서부터 시작하기 때문에 2번째의 인덱스는 1임 따라서 i == search() - 1의 형태임
		 */
		return -1;
	}
	
	public void print() {
		for (int i = front + 1; i < q.length; i++) { // 첫 번째칸은값을 저장하지 않는 칸이니까 1부터 시작함
			if (q[i] == null) { // null이면 출력중지
				break;
			}
			System.out.printf("%s\t ", q[i]);
		}
		System.out.println();
	}

}