public class Demo1 
{
	public static void main(String[] args) 
	{
		String s1="john";
		String s2="Mike";
		System.out.println("Hashcode is ="+s1.hashCode());
		s1="rohan";
		System.out.println("Hashcode is ="+s2.hashCode());
		String s3="john";
		System.out.println("hashcode is ="+s3.hashCode());
	}
}