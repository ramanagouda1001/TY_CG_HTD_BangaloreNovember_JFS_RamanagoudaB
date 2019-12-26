public class TestEmployee 
{
	public static void main(String[] args) 
	{
		Emloyee e= new Emloyee(22,"rohan");
		System.out.println(e.hashCode());
		System.out.println(e);
		Emloyee e1= new Emloyee(4,"shree");
		System.out.println(e.hashCode());
		System.out.println(e1);
		Object o=new Object();// just to see implememtation
		// example for hashcode
		System.out.println(o.hashCode());
	}
}
