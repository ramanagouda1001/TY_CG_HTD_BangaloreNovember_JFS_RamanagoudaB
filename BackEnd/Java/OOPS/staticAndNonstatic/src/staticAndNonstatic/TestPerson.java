package staticAndNonstatic;
public class TestPerson 
{
	public static void main(String[] args)
	{
		Person p1=new Person();
		Person.age=23;
		p1.name="john";
		p1.personDetails();
	}
}
