class Fact
{
	static int fact(int num)
	{
		if(num==0)
			return 1;	
		return num*fact(num-1);
	}
	public static void main(String arr[])
	{
		int value=fact(5);
		System.out.println("The factorial of 5 is = "+value);
	}
}
