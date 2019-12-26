public class Mutipletry 
{
	void exception(int a,String b)
	{
		try 
		{
			System.out.println(500/a);
			try
			{
				System.out.println(b.length());
			}
			catch(NullPointerException e)
			{
				System.out.println("dont deal with null String");
			}
		}
		catch(ArithmeticException e)
		{
			System.out.println("dividing by zero");
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("main started");
		Mutipletry obj=new Mutipletry();
		obj.exception(0,"Ramu");
		obj.exception(2, null);
		System.out.println("main ended");
	}
}
// to understand how this work comment all try block except line 7 then winows->show view->(console,vraiable)
// then use step in or step over