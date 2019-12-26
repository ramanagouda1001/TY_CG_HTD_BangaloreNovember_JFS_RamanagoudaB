public class Student 
{
	int studentId;
	String studentName;
	public Student(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	//override Tostring method
	@Override
	public String toString() {
		return "studentId=" + studentId + ", studentName=" + studentName;
	}
	
	
}
