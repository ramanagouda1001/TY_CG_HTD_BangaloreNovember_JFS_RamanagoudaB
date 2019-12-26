package checkedException;

public class NestedException {
		public static void main(String[] args) 
		{
			System.out.println("main stated");
			Student s=new Student();
			try
			{
				Object o1=s.clone();
				System.out.println("clone is done");
				try
				{
					Class c1=Class.forName("checkedException.Student");
				}
				catch(ClassNotFoundException c)
				{
					System.out.println("not found");
				}
				System.out.println("class found");
			} 
			catch (CloneNotSupportedException e) 
			{
				System.out.println("Clone not supported");
			} 
			
			System.out.println("main ended");//alt+(plus)+arrow
		}

	}

