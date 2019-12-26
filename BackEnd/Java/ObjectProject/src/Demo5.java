public class Demo5 
{
	public static void main(String[] args) 
	{
		Demo4 d=new Demo4(23, "rohan");
		System.out.println("preivous= "+d.hashCode());
		System.out.println(d.getAge());
		System.out.println(d.getName());//example for custom immutable class
		d=new Demo4(44, "pavan");
		System.out.println("new= "+d.hashCode());
		System.out.println(d.getAge());
		System.out.println(d.getName());
	}
}
