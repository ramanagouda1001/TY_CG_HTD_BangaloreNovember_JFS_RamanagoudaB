public class TestB
{
	void display()
	{
		String a=null;
		try 
		{
			System.out.println("length is"+a.length());
		}
		catch (NullPointerException e)
		{
			System.out.println("do not detail with null");
		}
		
	}
	public static void main(String[] args) 
	{
		System.out.println("main started");
		TestB b=new TestB();
		b.display();
		System.out.println("main ended");
	}
}
