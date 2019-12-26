package throwandthrows;
public class Paytm 
{
	IRCTC l1;

	public Paytm(IRCTC l1) {
		super();
		this.l1 = l1;
	}
	void confirmTicket()
	{
		try {
			l1.confirmBook();
			System.out.println("confirm");
		} catch (ClassNotFoundException e) {
			System.out.println("not ");
		}
	}
}
