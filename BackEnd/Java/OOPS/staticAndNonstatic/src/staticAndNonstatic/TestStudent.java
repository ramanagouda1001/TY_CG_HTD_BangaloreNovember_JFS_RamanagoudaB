package staticAndNonstatic;
public class TestStudent 
{
	public static void main(String[] args) 
	{
		Student s1=new Student();
		System.out.println("name is "+s1.stuName);
		System.out.println(" age is "+s1.stuAge);

		Student s2=new Student("rohan",23);
		System.out.println("name is "+s2.stuName);
		System.out.println(" age is "+s2.stuAge);
	}
}