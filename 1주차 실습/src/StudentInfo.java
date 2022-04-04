public class StudentInfo extends PersonInfo {
	private String deptName;
	private int stuID;
	
	StudentInfo(String name, int id, String deptName, int stuID) {
		super(name, id); this.deptName = deptName; this.stuID = stuID;
	}
	
	public void printStudentInfo() {
		super.printPersonInfo();
		System.out.println("deptName: " + this.deptName + " stuID: " + stuID);
	}
}