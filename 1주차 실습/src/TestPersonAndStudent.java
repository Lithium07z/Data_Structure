public class TestPersonAndStudent {
	public static void main(String[] args) {
		PersonInfo person = new PersonInfo("����ȣ", 7);
		StudentInfo student = new StudentInfo("����ȣ", 7,"������IT", 20195138);
		
		System.out.println("[PersonInfo]");
		person.printPersonInfo();
		System.out.println("[studentInfo]");
		student.printStudentInfo();
	}
}
