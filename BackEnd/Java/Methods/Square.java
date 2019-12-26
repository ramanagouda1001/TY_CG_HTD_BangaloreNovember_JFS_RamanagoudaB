class Square
{
	static int areaSquare(int r)
	{
		int area=r*r;	
		return area;
	}
	static int perimeterSquare(int r)
	{
		int perimeter=4*r;
		return perimeter;
	}
	public static void main(String arr[])
	{
		int result=areaSquare(6);
		int result1=perimeterSquare(7);
		System.out.println("the area of circle is = "+result);
		System.out.println("the perimeter of circle = "+result1);  
	}
}