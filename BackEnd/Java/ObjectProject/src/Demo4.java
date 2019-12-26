public class Demo4 
{
	private int age;//example for custom immutable class
	private String name;// private variable
	public Demo4(int age, String name) {// public construvtor paramterzied
		super();
		this.age = age;
		this.name = name;
	}
	public String getName()  // public getter
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
}