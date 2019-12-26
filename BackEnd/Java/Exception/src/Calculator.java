public class Calculator 
{
	void divide(int a,int b)
	{
		System.out.println("divide stated");
		try
		{
			System.out.println(a/b);
		}
		catch(ArithmeticException e)
		{
			System.out.println("divide by zero");
		}
		System.out.println("ended stated");
	}
}
