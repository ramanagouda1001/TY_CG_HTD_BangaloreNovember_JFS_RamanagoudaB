class ElseIF
{
	public static void main(String arr[])
	{
		int a=20;
		int b=30;
		int c=200;
		int d=380;
		if(a > b &&  a > c &&  a > d)
		{
			System.out.println("A is greater");
		}
		else if( b > c &&  b > d)
		{
			System.out.println("B is greater");
		}
		else if( c > d)
		{
			System.out.println("C is greater");		
		}
		else
		{
			System.out.println("D is greater")	;	
		}
	}
}