import java.io.FileInputStream;
import java.io.IOException;

public class read {
	public static void main(String[] args) 
	{
		try {
		FileInputStream f1=new FileInputStream("rohan.txt");
		int j=0;
			while((j=f1.read())!=-1)
			{
				System.out.print((char)j);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
