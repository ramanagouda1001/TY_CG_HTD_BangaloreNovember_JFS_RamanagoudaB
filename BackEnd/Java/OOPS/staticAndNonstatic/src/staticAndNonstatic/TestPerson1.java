package staticAndNonstatic;
public class TestPerson1 
{
	public static void main(String[] args) 
	{
		Person1 p1=new Person1();
		p1.age=23;
		p1.name="rohan";
		p1.displayDetails();
		Person1 p2=new Person1();
		p2.initialize(2,"hi");
		p2.displayDetails();
	}
}