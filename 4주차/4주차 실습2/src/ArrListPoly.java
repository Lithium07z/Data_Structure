public class ArrListPoly extends ArrList {
	private int HighestDegree;

	public void setPoly(int highestDegree, int[] poly) {
		this.HighestDegree = highestDegree; // HighestDegree �ʱ�ȭ;
		for (int i = 0; i < poly.length; i++) {
			insertLast(poly[i]); // ArrListPoly�� ����� ArrList�� �����迭�� insetLast �޼ҵ带 �̿��� ����
		}
	}

	public ArrListPoly sumPoly(ArrListPoly p1) {
		ArrListPoly p = new ArrListPoly(); // ��� �� ���� ArrListPoly ����
		int max; // HighestDegree�� �ְ������� �ǹ��ϴϱ� �� ���׽� �� ���� ū�� HighestDegree�� ���ؼ� �� �� ����
		int min; 
		if (this.HighestDegree > p1.HighestDegree) { // ū ���� max�� ���� ���� min��
			max = this.HighestDegree;
			min = p1.HighestDegree;
		} else { 
			max = p1.HighestDegree;
			min = this.HighestDegree;
		}
		
		int count = 0;
		int arr[] = new int[max + 1]; // �� ���׽��� ���� ���� �迭
		for (int i = 0; i <= max; i++) {
			if (count <= min && max == this.HighestDegree) { // this�� p1���� ũ�� ������ 
				arr[i] = (int) this.peek(i) + (int) p1.peek(count); // p1�� �����ϱ� p1�� �ڱ� ũ�⸸ŭ�� �ݺ��ؼ� �߰���
				count++; 
			} else if (count <= min && max == p1.HighestDegree) { // p1�� this���� ũ�� ������
				arr[i] = (int) this.peek(count) + (int) p1.peek(i); // this�� �����ϱ� this�� �ڱ� ũ�⸸ŭ�� �ݺ��ؼ� �߰���
				count++;
			} else if (max == this.HighestDegree) { // ���� ���� �ݺ��� ������ ū ���� ���� �߰��� 
				arr[i] = (int) this.peek(i);
			} else if (max == p1.HighestDegree) { // ���� ���� �ݺ��� ������ ū ���� ���� �߰��� 
				arr[i] = (int) p1.peek(i);
			}
		}
		p.setPoly(max, arr); // ���� ������� ���׽��� �� ���׽� �� �ְ������� ���׽İ� ũ�Ⱑ �����״� HighestDegree�� max������ ��
		return p; // ���׽��� ���� ���� ArrListPoly p ��ȯ
	}

	public int getHighestDegree() {
		return this.HighestDegree;
	}
}
