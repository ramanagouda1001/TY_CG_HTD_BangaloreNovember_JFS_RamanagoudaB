package staticAndNonstatic;
public class Son extends Father
{
	Son()
	{
		super("rohan",22);
		System.out.println("C");
	}
	Son(String name,int age)
	{//constructor recurrsion is not possible
		// constructor can not be inherited from parent to child class
		// constructor cannot be final,static,synchronized,abstract
		this();
		System.out.println("D");
	}
}
