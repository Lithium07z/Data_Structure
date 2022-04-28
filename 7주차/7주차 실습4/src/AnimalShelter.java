
public class AnimalShelter {
	Animal ani = new Animal();
	Type aniType = new Type();

	public void enter(String name, String type) {
		ani.add(name);
		aniType.add(type);
	}

	public void adoptAny() {
		ani.remove();
		aniType.remove();
	}

	public void adoptCat() {
		adoptAnimal("Cat");
	}

	public void adoptDog() {
		adoptAnimal("Dog");
	}
	
	public void adoptAnimal(String type) {
		int fixedSize = ani.size(); // ���� ����� �޾Ƽ� �������� �ʰ� ������ ����
		int fixedPosition = aniType.search(type); // ���� ã������ ���� ��ġ�� �޾Ƽ� �������� �ʰ� ������ ���� 
		String arrAni[] = new String[ani.size() - 1]; // �̸� �ϳ� ����� arr�� �����Ŵϱ� ���� ������ -1ũ�� �迭 ����
		String arrAniType[] = new String[ani.size() - 1]; // ���� �ϳ� ����� arr�� �����Ŵϱ� ���� ������ -1ũ�� �迭 ����
		
		for (int i = 0; i < fixedSize; i++) { // �Ʊ� ������Ų �����ŭ �ݺ�
			if (i == fixedPosition - 1) { // ������ �ϴ� ��ġ�� (i�� 0���� �����ϱ� ������ ���� ��ġ -1�� �������)
				ani.remove(); // remove�� �ϰ� �迭�� �߰��� ���� ���� 
				aniType.remove();
			} else if (i > fixedPosition - 1) { 
				arrAni[i - 1] = (String) ani.remove(); // ���� ��� ������ i�� 1�� �и��״� -1�ؼ� �߰����� 
				arrAniType[i - 1] = (String) aniType.remove();
			} else { // ������ �ϴ� ��ġ���� ������ ��� 
				arrAni[i] = (String) ani.remove(); 
				arrAniType[i] = (String) aniType.remove();
			} // �ᱹ �� ���� ť�� �ϳ��� ťó�� ����ϴ� ����̴�. �Է����� ��ü�� �ް� �ϳ��� ť�� ���� ����� �ƶ������� ������ 
		}
		
		for (int i = 0; i < arrAni.length; i++) {
			ani.add(arrAni[i]); // ����� ���� ���� ������ �迭�� �ٽ� ť�� ���� 
			aniType.add(arrAniType[i]);
		}
	}

	public void print() {
		ani.print();
	}
}