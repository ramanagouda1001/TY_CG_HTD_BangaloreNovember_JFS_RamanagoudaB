public class Vehicle implements Cloneable//in order to use clone we must use cloneable interface and its a marker interface
{
	String name;

	public Vehicle(String name) 
	{
		super();
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}