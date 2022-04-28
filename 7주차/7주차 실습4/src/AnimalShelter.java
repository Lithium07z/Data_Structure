
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
		int fixedSize = ani.size(); // 먼저 사이즈를 받아서 변동되지 않게 변수에 넣음
		int fixedPosition = aniType.search(type); // 먼저 찾으려는 동물 위치를 받아서 변동되지 않게 변수에 넣음 
		String arrAni[] = new String[ani.size() - 1]; // 이름 하나 지우고 arr에 넣을거니까 지금 사이즈 -1크기 배열 생성
		String arrAniType[] = new String[ani.size() - 1]; // 동물 하나 지우고 arr에 넣을거니까 지금 사이즈 -1크기 배열 생성
		
		for (int i = 0; i < fixedSize; i++) { // 아까 고정시킨 사이즈만큼 반복
			if (i == fixedPosition - 1) { // 지워야 하는 위치면 (i가 0부터 시작하기 때문에 받은 위치 -1을 해줘야함)
				ani.remove(); // remove만 하고 배열에 추가는 하지 않음 
				aniType.remove();
			} else if (i > fixedPosition - 1) { 
				arrAni[i - 1] = (String) ani.remove(); // 위의 경우 때문에 i가 1씩 밀릴테니 -1해서 추가해줌 
				arrAniType[i - 1] = (String) aniType.remove();
			} else { // 지워야 하는 위치보다 이전인 경우 
				arrAni[i] = (String) ani.remove(); 
				arrAniType[i] = (String) aniType.remove();
			} // 결국 두 개의 큐를 하나의 큐처럼 사용하는 방법이다. 입력으로 객체를 받고 하나의 큐를 쓰는 방법과 맥락상으로 동일함 
		}
		
		for (int i = 0; i < arrAni.length; i++) {
			ani.add(arrAni[i]); // 지우고 남은 값을 저장한 배열을 다시 큐에 저장 
			aniType.add(arrAniType[i]);
		}
	}

	public void print() {
		ani.print();
	}
}