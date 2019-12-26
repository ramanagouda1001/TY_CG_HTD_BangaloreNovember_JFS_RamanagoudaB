public class TestInstance 
{
	public static void main(String[] args) 
	{
		InstanceBlock f=new InstanceBlock();
		System.out.println(f.a);
		System.out.println(InstanceBlock.PI);
		System.out.println("-----------------------------");
		InstanceBlock f2=new InstanceBlock(3);
		System.out.println(f2.a);
	}
}
