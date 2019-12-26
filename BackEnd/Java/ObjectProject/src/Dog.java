public class Dog 
{
	String name;
	public Dog()
	{
		
	}
	public Dog(String name) 
	{
		super();
		this.name = name;
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException 
	{
		Dog d=new Dog("hi");
		Class c=d.getClass();
		Dog d2=(Dog) c.newInstance();//used to create a object and it allows looks for zero parmeter constructor if not it will through error
		Class c2=Class.forName("Dog");// used to get a class name
		System.out.println(c);
		System.out.println(c2);
		System.out.println(d2.name);
		//example for getclass method
				
	}
	
}
