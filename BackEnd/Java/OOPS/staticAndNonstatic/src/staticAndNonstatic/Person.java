package staticAndNonstatic;
public class Person 
{
	static int age;
	String name;
	void personDetails()
	{
		System.out.println("The name of the person is "+name+" and age is "+age);
		personDetailsStatic();
	}
	static void personDetailsStatic()
	{
		System.out.println(age);
	}
}
