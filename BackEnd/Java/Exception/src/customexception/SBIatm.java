package customexception;
public class SBIatm 
{
	public static void main(String[] args) 
	{
		System.out.println("Main class started");
		ATMSimulator s=new ATMSimulator();
		try
		{
			s.withdraw(41000);
		}
		catch(DayLimitException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Main class ended");
	}
}
