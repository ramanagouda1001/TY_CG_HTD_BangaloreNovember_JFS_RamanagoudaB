package staticAndNonstatic;
public class Employee 
{
	int empage;
	String empname;
	double empsalary;
	public Employee(int age, String name, double salary) {
		empage = age;
		empname = name;
		empsalary = salary;
	}
	void display()
	{
		System.out.println("AGE IS:"+empage+" NAME IS:"+empname+" SALARY IS:"+empsalary);
	}
	
}
