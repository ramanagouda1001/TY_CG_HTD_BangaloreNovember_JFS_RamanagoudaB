public class TestVehicle 
{
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Vehicle v1=new Vehicle("BNW");
		Object o1=v1.clone();// this is only available 
		Vehicle v2=(Vehicle) o1;
		System.out.println(v2.name);
	}
}
