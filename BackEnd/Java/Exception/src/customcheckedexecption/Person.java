package customcheckedexecption;
public class Person 
{
	public static void main(String[] args) 
	{
		System.out.println("main started");
		Age a=new Age();
		try {
			a.vote(16);
		} catch (AgeLimitException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	}
}
