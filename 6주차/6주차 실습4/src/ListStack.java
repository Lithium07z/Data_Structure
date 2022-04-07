import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top;
	private int size;

	public ListStack() {
		top = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getItem();
	}

	public void push(E newItem) {
		Node newNode = new Node(newItem, top);
		top = newNode;
		size++;
	}

	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E topItem = top.getItem();
		top = top.getNext();
		size--;
		return topItem;
	}

	public String getPostEq(String s) {
		String value = ""; // 후위표기법을 적을 String 선언
		int count = 0; // 식에 소괄호만 들어온다고 가정했을 때, 식의 괄호가 완전한지 검사하는 변수
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { // 연산자면
				count++; // 괄호가 추가되면 +1
				push((E) "("); // 스택에 저장
			} else if (s.charAt(i) == '*') {
				push((E) "*");
			} else if (s.charAt(i) == '/') {
				push((E) "/");
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				// 더하기, 빼기면 자신의 우선순위보다 낮은 연산자가 top에 올때까지 pop해야 함
				for (int j = 0; j < size(); j++) { // 안에 있는거 다 팝
					if (String.valueOf(peek()).equals("(")) { // 단, 여는 괄호가 있으면 pop하지 않음
						break; // 탈출
					} else {
						value += String.valueOf(pop()); // pop한거 value에 추가
					}
				}
				push((E) String.valueOf(s.charAt(i))); // 여는 괄호가 있어서 pop을 못하면 스택에 추가
			} else if (s.charAt(i) == ')') { // 닫는 괄호면
				count++; // 괄호가 있으면 +1
				int fixSize = size(); // 지금사이즈 기억하고
				for (int j = 0; j < fixSize; j++) { // 지금 사이즈만큼 반복해서 pop
					String add = String.valueOf(pop()); // pop한 값 add에 저장해놓고 검사
					if (add.equals("(")) { // pop하다가 닫는 괄호 나오면
						break; // 거기까지
					} else {
						value += add; // 아니면 저장해놨던 add, value에 추가
					}
				}
			} else {
				value += String.valueOf(s.charAt(i)); // 피연산자인 경우 value에 추가
			}
		}
		if (count % 2 != 0) { // 괄호가 짝수가 아닌경우
			System.out.println("괄호의 짝이 맞지 않습니다. 식을 다시 확인해주세요");
			System.exit(0);
		}
		for (int i = 0; i < size(); i++) {
			value += String.valueOf(pop());
		} // 마지막에 스택에 남아있는 값들 전부 value에 추가
		return value; // value 리턴
	}

	public double calc(String[] s) {
		double front; // double 타입으로 먼저 온 피연산자 저장하는 변수 
		double back; // double 타입으로 뒤에 오는 피연산자 저장하는 변수 
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("*") | s[i].equals("/") || s[i].equals("+") || s[i].equals("-")) { // 연산자면
				back = (double) pop(); // 먼저 pop해서 나오는 값을 back에
				front = (double) pop(); // 다음 pop해서 나오는 값을 front에 넣는다
				if (s[i].equals("*")) { // 각각의 연산자에 맞는 연산 수행
					push((E) Double.valueOf(front * back)); // double객체로 만들어서 제너릭으로 캐스팅
				} else if (s[i].equals("/")) {
					push((E) Double.valueOf(front / back));
				} else if (s[i].equals("+")) {
					push((E) Double.valueOf(front + back));
				} else if (s[i].equals("-")) {
					push((E) Double.valueOf(front - back));
				}
			} else {
				push((E) Double.valueOf(s[i])); // 피연산자는 double객체로 만들어서 제너릭으로 캐스팅한 후 push
			}
		}
		return (double)peek(); // 다 끝나고 마지막에 스택에 있는 값이 결과값이니까 peek로 꺼내서 double형으로 반납
	}

	public void print() {
		E[] arr = (E[]) new Object[size];
		int cnt = size;
		for (int i = 0; i < cnt; i++) {
			arr[i] = pop();
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = cnt - 1; i >= 0; i--) {
			push(arr[i]);
		}
	}
}
