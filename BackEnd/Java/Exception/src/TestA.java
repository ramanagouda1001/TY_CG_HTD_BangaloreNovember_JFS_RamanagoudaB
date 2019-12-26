public class TestA 
{
	public static void main(String[] args) 
	{
		System.out.println("main started");
		Calculator c=new Calculator();
		c.divide(10, 0);
		System.out.println("main ended");
		
	}
}
