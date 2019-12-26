package throwkey;
public class Ola 
{
	GoogleApp g;

	public Ola(GoogleApp g) {
		super();
		this.g = g;
	}
	void location(String n)
	{
		try
		{
			g.findLocation(n);
		}
		catch(NullPointerException e)
		{
			System.out.println("ola user Plz enter location details");
		}
		
	}
}
