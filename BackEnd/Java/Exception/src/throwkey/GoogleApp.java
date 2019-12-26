package throwkey;
public class GoogleApp 
{
	void findLocation(String n)
	{
		try
		{
			System.out.println(n.length());
		}
		catch(NullPointerException e)
		{
			System.out.println("Google user plz enter correct");
			throw e;
		}
		
	}
}
