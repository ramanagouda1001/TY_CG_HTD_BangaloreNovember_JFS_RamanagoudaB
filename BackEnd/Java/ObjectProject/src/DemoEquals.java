public class DemoEquals 
{
	public static void main(String[] args) 
	{
		String s1="rohan";
		String s2= new String("rohan");
		System.out.println(s1.equals(s2));// compare the values
		System.out.println(s1==s2);// compare hashcode
	}
}
