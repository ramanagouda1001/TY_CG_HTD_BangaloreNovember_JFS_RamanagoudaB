public class Person 
{
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}
@Override
	protected void finalize() throws Throwable {//it is called automatically and we cannot predecit when it is called and if we call the finalize method but to grabage  collector is not exceuted
		// TODO Auto-generated method stub
	
	System.out.println("finalize method");
		super.finalize();
	}	
	public static void main(String[] args) throws Throwable 
	{
		System.out.println("--------main----------");
		Person p=new Person("hi");
		p.finalize();
		p=null;
		System.gc();
		System.out.println("-----------ended---------------");
	}

}
