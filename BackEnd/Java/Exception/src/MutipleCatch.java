public class MutipleCatch 
{
	void exception(int a,String b)
	{
		try
		{
			System.out.println(500/a);
			System.out.println(b.length());
		}
		catch(ArithmeticException e)
		{
			System.out.println("dont not deal with zero");
		}
		catch(NullPointerException e)
		{
			System.out.println("do not deal with empty string");
		}
	}
	public static void main(String[] args)
	{
		MutipleCatch obj=new MutipleCatch();
		obj.exception(0, "Ramu");
		obj.exception(2, null);
	}
}
