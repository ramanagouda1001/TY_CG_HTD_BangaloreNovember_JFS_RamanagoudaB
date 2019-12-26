package throwandthrows;
public class IRCTC 
{
	void confirmBook() throws ClassNotFoundException
	{
		try {
			Class c1=Class.forName("throwandthrows.Paytm");
			System.out.println("confirm");
		} catch (ClassNotFoundException e)
		{
			System.out.println("ticket is not confired");
			throw e;
		}
	}
}
