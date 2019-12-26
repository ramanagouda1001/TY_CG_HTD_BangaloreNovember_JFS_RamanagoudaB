class Methods
{
	static void add(int a,int b)
	{
		System.out.println("the value  of a + b is "+(a+b));
	}
	static void sub(int a,int b)
	{
		System.out.println("the value  of a - b is "+(a-b));
	}
	static void mul(int a,int b)
	{
		System.out.println("the value  of a * b is "+(a*b));
	}
	static void div(int a,int b)
	{
		System.out.println("the value  of a / b is "+(a/b));
	}
	static void mod(int a,int b)
	{
		System.out.println("the value  of a %	 b is "+(a%b));
	}
	public static void main(String arr[])
	{
		add(30,40);
		sub(20,10);
		mul(10,10);
		div(20,10);
		mod(8,2);
	}
}