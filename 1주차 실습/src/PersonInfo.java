public class PersonInfo {
		private String name;
		private int id;
		
		PersonInfo(String name, int id) {
			this.name = name; this.id = id;
		}
		public void printPersonInfo() {
			System.out.println("name: " + this.name + " id: " + this.id);
		}

}
