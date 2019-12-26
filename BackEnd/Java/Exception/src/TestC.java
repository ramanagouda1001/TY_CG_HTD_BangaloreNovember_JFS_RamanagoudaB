public class TestC 
{
	public static void main(String[] args) 
	{
		System.out.println("started");
		int a[]=new int[2];
		a[0]=0;
		a[1]=2;
		try 
		{
			a[2]=3;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("out of bound");
		}
		System.out.println("ended");
			
	}
}
