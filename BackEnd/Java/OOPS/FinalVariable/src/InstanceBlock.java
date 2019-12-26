public class InstanceBlock 
{
	final int a;
	static final double PI;
	public InstanceBlock() {
		// TODO Auto-generated constructor stub
		System.out.println("constrctor is called");
	}
	public InstanceBlock(int a)
	{
		System.out.println("overloaded is called");
	}
	{
		System.out.println("Instance block is called");
		this.a=23;
	}
	static {
		System.out.println("Static is called");
		PI=3.1432;
	}
}
