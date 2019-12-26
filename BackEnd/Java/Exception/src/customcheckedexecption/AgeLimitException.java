package customcheckedexecption;
public class AgeLimitException extends Exception 
{
	String msg="u do not have age greater than 18";

	public AgeLimitException() {
		super();
	}

	public AgeLimitException(String msg) {
		super();
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
	
}
