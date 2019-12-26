package checkedException;
public class Exception 
{

	public static void main(String[] args) 
	{
		System.out.println("main stated");
		Student s=new Student();
		try
		{
			Object o1=s.clone();
			System.out.println("clone is done");
			Class c1=Class.forName("checkedException.Student");
			System.out.println("class found");
		} 
		catch (CloneNotSupportedException e) 
		{
			System.out.println("Clone not supported");
		} 
		catch (ClassNotFoundException c) 
		{
			System.out.println("class not found");
		}
		System.out.println("main ended");
	}

}
