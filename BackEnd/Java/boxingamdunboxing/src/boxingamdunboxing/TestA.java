package boxingamdunboxing;
public class TestA
{
	public static void main(String[] args) 
	{
		int i1=10;
		Integer i2=new Integer(i1);
		int i3=i2.intValue();
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
	}
}
