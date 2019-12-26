public class Finally 
{
	public static void main(String[] args) 
	{
		System.out.println("main stated");
		try
		{
			System.out.println(100/0);
		}
		catch(ArithmeticException e)
		{
			System.out.println("do not deal wih zero");
		}
		finally
		{
			System.out.println("finally excetued");
		}
		System.out.println("main ended");
	}
}
// if exception is not handeled it will do 
//1.print exception details
//2.print stackTrace deatails
//3.terminates