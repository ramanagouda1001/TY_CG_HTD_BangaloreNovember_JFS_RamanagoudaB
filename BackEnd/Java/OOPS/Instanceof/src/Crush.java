
public class Crush
{
	void receive(Phone p)
	{
		if(p instanceof BasicsSet)
		{
			System.out.println("thanks");
		}
		else if(p instanceof Oppo)
		{
			System.out.println("thanks you");
		}
		else if(p instanceof OnePlus)
		{
			System.out.println("Thanks you so  much dear");
		}
		else if(p instanceof Apple)
		{
			System.out.println("love you");
		}
		else
		{
			System.out.println("idiot");
		}
	}
}
