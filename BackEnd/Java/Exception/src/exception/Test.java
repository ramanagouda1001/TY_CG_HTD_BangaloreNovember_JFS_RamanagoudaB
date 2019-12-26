package exception;
public class Test 
{
	public static void main(String[] args)
	{
		System.out.println("main started");
		try
		{
			A.o();
		}
		catch(ArithmeticException e)
		{
			System.out.println("main "+e.getMessage());
		}		
		
	}
}
