import java.util.NoSuchElementException;

public class ArrList <E>{
	private E a[];
	private int size;
	
	public ArrList() {
		a = (E[]) new Object[1]; // 제너릭 타입이기에 Object로 만들어 모든 값 수용 가능하게
		size = 0;
	}
	
	public E peek(int k) {
		if (size == 0 || k >= size) { // 데이터가 없거나 인덱스 k가 size크기 보다 크면
			throw new NoSuchElementException(); // 값 없음 예외처리
		}
		return a[k];
	}
	public boolean isEmpty() { // 배열내 데이터 유무 True, False
		if (size == 0) {
			return true;
		}
		return false;
	}
	public void insertLast(E newItem) { // 최후미에 값 추가
		if (size == a.length) { // 배열이 꽉찼다면
			resize(a.length * 2); // 2배로 확장
		}
		a[size++] = newItem; // 새 항목 삽입 + 사이즈 증가 [size != length 주의!!]
	}
	public void insert(E newItem, int k) {
		if (size == a.length) { // 배열이 꽉찼다면
			resize(a.length * 2); // 2배로 확장
		}
		for (int i = size - 1; i >= k ; i--) { // 마지막 값부터
			a[i + 1] = a[i]; // 뒤로 하나씩 이동시키기
		}
		a[k] = newItem; // 이동이 끝나고 빈 공간에 값 추가
		size++; // 전체 배열의 크기가 증가했으니 size++
	}
	public void insert(E newItem) { // 메소드 오버로딩
		insertLast(newItem); // 값을 추가하기 위한 값이 없으면 최후미 추가
	}
	private void resize(int newSize) { // 새로운 배열크기 받음
		Object[] t = new Object[newSize]; // 최상위 개체인 Objcet로 새 배열 생성
		for (int i = 0; i < size; i++) {
			t[i] = a[i]; // 새로 만들어진 배열에 데이터 넣기
		}
		a = (E[])t; // 데이터 복사가 끝난 배열을 제너릭타입으로 캐스팅해줌 
	}
	public E delete(int k) { // 삭제할 인덱스 k 
		if (isEmpty()) {
			throw new NoSuchElementException(); // underflow
		}
		E item = a[k]; // 리턴하기위해 임시저장
		for (int i = k; i < size - 1; i++ ) {
			a[i] = a[i + 1];
		}
		size--;
		if (size > 0 && size <= a.length/4) { // 배열의 4분의 1만 사용됨
			resize(a.length/2); // 배열의 반을 줄임
		}
		return item; // 삭제된 item 반환
	}
	public void print() {
		for (int i = 0; i < a.length; i++) {
			if (i < size) {
				System.out.print(a[i] + "\t"); // 값 출력후 탭
			} else {
				System.out.print("null\t"); // 빈 값은 null로 출력해 구분
			}
		}
		System.out.println();
	}
}