
public class Main {
	public static void main(String[] args) {
		AnimalShelter as = new AnimalShelter();
		
		as.enter("Brad", "Dog");  as.enter("Tom", "Dog"); 
		as.enter("Cindy", "Cat"); as.enter("Jake", "Dog"); 
		as.enter("Jenny", "Cat"); as.enter("Alex", "Dog");
		as.enter("Lucy", "Cat");  as.enter("Maggie", "Cat");
		as.print();
		as.adoptAny();
		as.print();
		as.adoptCat();
		as.print();
		as.adoptDog();
		as.print();
		as.adoptAny();
		as.print();
		as.adoptDog();
		as.print();

	}
}
