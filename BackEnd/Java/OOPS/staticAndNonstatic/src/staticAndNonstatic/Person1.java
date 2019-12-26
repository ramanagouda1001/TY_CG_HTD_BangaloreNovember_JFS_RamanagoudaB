package staticAndNonstatic;
public class Person1 
{
	int age;
	String name;
	void displayDetails()
	{
		System.out.println("the name of the person "+name+" and age is "+age);
	}
	void initialize(int n,String a)
	{
		age=n;
		name=a;
	}
}
