public class Demo2 
{
	public static void main(String[] args) 
	{
		String s1=new String("john");
		System.out.println(s1.hashCode());
		String s2=new String("mike");
		String s3=new String("john");
		s1=new String("rohan");
		System.out.println(s1.hashCode());
		
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
	}

}
