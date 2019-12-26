package throwandthrows;

public class User 
{
	public static void main(String[] args) 
	{
		IRCTC l=new IRCTC();
		Paytm p=new Paytm(l);
		p.confirmTicket();
	}
}
