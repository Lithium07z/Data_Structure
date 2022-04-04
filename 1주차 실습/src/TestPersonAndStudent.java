public class TestPersonAndStudent {
	public static void main(String[] args) {
		PersonInfo person = new PersonInfo("±èÁØÈ£", 7);
		StudentInfo student = new StudentInfo("±èÁØÈ£", 7,"ÄÜÅÙÃ÷IT", 20195138);
		
		System.out.println("[PersonInfo]");
		person.printPersonInfo();
		System.out.println("[studentInfo]");
		student.printStudentInfo();
	}
}
