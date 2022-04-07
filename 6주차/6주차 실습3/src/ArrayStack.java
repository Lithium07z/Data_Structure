import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // 스택을 위한 배열
	private int top; // 스택의 top 항목의 배열 원소 인덱스

	public ArrayStack() { // 스택 생성자
		s = (E[]) new Object[1]; // 처음엔 크기가 1인 배열 생성
		top = -1;
	}

	public int size() {
		return top + 1; // 스택에 있는 항목의 수를 리턴
	}

	public boolean isEmpty() { // 스택이 empty면 true 리턴
		return top == -1;
	}

	public E peek() { // 스택 top 항목의 내용만을 리턴
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return s[top];
	}

	public void push(E newItem) { // push 연산
		if (size() == s.length) {
			resize(2 * s.length); // 스택을 2배의 크기로 확장
		}
		s[++top] = newItem; // 새 항목 push
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E item = s[top];
		s[top--] = null; // null로 초기화
		if (size() > 0 && size() == s.length / 4) { // 저장된 값이 배열의 1/4 크기면
			resize(s.length / 2); // 스택을 반으로 축소
		}
		return item;
	}

	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		for (int i = 0; i < size(); i++) {
			t[i] = s[i];
		}
		s = (E[]) t;
	}

	public boolean checkParentheses(String s) {
		Loop: for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // 괄호면
				push((E) "("); // 스택에 저장
			} else if (s.charAt(i) == '{') {
				push((E) "{");
			} else if (s.charAt(i) == '[') {
				push((E) "[");
			} else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') { // 닫는 괄호면
				String compare = null;
				if (s.charAt(i) == ')') { // 닫는 괄호의
					compare = "("; // 짝이되는 괄호를 compare에 넣고
				} else if (s.charAt(i) == '}') {
					compare = "{";
				} else if (s.charAt(i) == ']') {
					compare = "[";
				}
				for (int j = 0; j < size(); j++) {
					if (String.valueOf(pop()).equals(compare)) { // 같으면
						continue Loop; // 다음 검사로
					}
				}
				return false; // 다르면 false 리턴
			} // 아스키 코드 이용해서 코드 압축하려 했는데 소괄호는 연속해서 있어서 소괄호만 따로 만들어줘야함 :(
		}
		if (size() != 0) { // 검사 끝났는데 스택에 뭔가 있으면 개행된 괄호가 있다는 거니까
			for (int i = 0; i < size(); i++) { // 스택안에 남는 값이 없도록
				pop(); // 다 빼버림
			}
			return false; // 그리고 false 리턴
		}
		return true; // 아니면 true
	}

	public boolean checkPalindrome(String s) {
		int pass = -1;
		if (s.length() % 2 != 0) { // 홀수면
			pass = s.length() / 2; // 건너뛰어야 될 중간 인덱스 pass에 저장
		}
		for (int i = 0; i < s.length(); i++) { // 전체 길이만큼 반복하는데
			if (pass > 0 && i == pass) { // pass가 있으면
				continue; // 거기만 패스 
			}
			if (i < s.length() / 2 || s.length() == 1) { // 앞 절반에선(s.length() == 1인 이유는 1이면 push가 안되서 넣음)
				push((E) String.valueOf(s.charAt(i))); // 스택에 추가하고
			} else { // 나머지 절반에선
				if (String.valueOf(pop()).equals(String.valueOf(s.charAt(i)))) { // 스택에 넣은거랑 나머지 반이랑 검사
					continue; // 같으면 continue;
				} else {
					return false; // 다르면 false 리턴
				}
			}
		}
		return true; // 다 통과하면 true;
	}

	public void print() {
		for (E value : s) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
}