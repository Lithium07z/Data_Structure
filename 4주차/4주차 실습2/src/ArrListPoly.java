public class ArrListPoly extends ArrList {
	private int HighestDegree;

	public void setPoly(int highestDegree, int[] poly) {
		this.HighestDegree = highestDegree; // HighestDegree 초기화;
		for (int i = 0; i < poly.length; i++) {
			insertLast(poly[i]); // ArrListPoly에 연결된 ArrList의 동적배열에 insetLast 메소드를 이용해 삽입
		}
	}

	public ArrListPoly sumPoly(ArrListPoly p1) {
		ArrListPoly p = new ArrListPoly(); // 결과 값 넣을 ArrListPoly 생성
		int max; // HighestDegree는 최고차항을 의미하니까 두 다항식 중 누가 큰지 HighestDegree를 비교해서 알 수 있음
		int min; 
		if (this.HighestDegree > p1.HighestDegree) { // 큰 쪽을 max에 작은 쪽을 min에
			max = this.HighestDegree;
			min = p1.HighestDegree;
		} else { 
			max = p1.HighestDegree;
			min = this.HighestDegree;
		}
		
		int count = 0;
		int arr[] = new int[max + 1]; // 두 다항식의 합을 담을 배열
		for (int i = 0; i <= max; i++) {
			if (count <= min && max == this.HighestDegree) { // this가 p1보다 크기 때문에 
				arr[i] = (int) this.peek(i) + (int) p1.peek(count); // p1이 작으니까 p1은 자기 크기만큼만 반복해서 추가됨
				count++; 
			} else if (count <= min && max == p1.HighestDegree) { // p1이 this보다 크기 때문에
				arr[i] = (int) this.peek(count) + (int) p1.peek(i); // this가 작으니까 this는 자기 크기만큼만 반복해서 추가됨
				count++;
			} else if (max == this.HighestDegree) { // 작은 쪽의 반복이 끝나면 큰 쪽의 값만 추가함 
				arr[i] = (int) this.peek(i);
			} else if (max == p1.HighestDegree) { // 작은 쪽의 반복이 끝나면 큰 쪽의 값만 추가함 
				arr[i] = (int) p1.peek(i);
			}
		}
		p.setPoly(max, arr); // 새로 만들어진 다항식은 두 다항식 중 최고차항인 다항식과 크기가 같을테니 HighestDegree를 max값으로 줌
		return p; // 다항식의 합을 가진 ArrListPoly p 반환
	}

	public int getHighestDegree() {
		return this.HighestDegree;
	}
}
