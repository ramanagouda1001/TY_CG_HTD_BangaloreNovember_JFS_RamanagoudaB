package throwkey;
public class TestA 
{
	public static void main(String[] args) 
	{
		System.out.println("main started");
		GoogleApp g=new GoogleApp();
		Ola o=new Ola(g);
		o.location(null);
		System.out.println("main ended");
	}

}
