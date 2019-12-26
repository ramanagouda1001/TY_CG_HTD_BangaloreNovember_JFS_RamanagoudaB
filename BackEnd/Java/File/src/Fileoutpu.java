import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fileoutpu 
{
	public static void main(String[] args) 
	{
		try {
			FileOutputStream f1=new FileOutputStream("rohan.txt");
			
			String v="rohan is my name";
			byte a[]=v.getBytes();
			f1.write(a);
			System.out.println("suces---");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
