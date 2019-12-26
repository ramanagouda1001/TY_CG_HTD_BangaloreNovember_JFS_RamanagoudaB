
public class Atm 
{
	void money(Bank b)//loose coupling
	{
		b.withdraw();
	}
//	void money(Hdfc d)
//	{
//		tight coupling 
//	}
}
