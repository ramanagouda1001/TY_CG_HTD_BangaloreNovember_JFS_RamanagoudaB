class Circle
{
	static double areaCircle(int r)
	{
		double area=3.14*r*r;
		return area;
	}
	static double perimeterCircle(int r)
	{
		double perimeter=2*3.14*r;
		return perimeter;
	}
	public static void main(String arr[])
	{
		double result=areaCircle(6);
		double result1=perimeterCircle(7);
		System.out.println("the area of circle is ="+result);
		System.out.println("the perimeter of circle ="+result1);  
	}
}