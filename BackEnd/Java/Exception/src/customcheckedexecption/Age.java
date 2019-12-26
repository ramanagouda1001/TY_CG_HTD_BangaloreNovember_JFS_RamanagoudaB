package customcheckedexecption;
public class Age 
{
	void vote(int age) throws AgeLimitException
	{
		if(age<18)
			throw new AgeLimitException();
		else
			System.out.println("u allowed to vote");
	}
}

