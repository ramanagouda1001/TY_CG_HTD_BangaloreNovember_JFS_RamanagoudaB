import java.util.*;

public class Stringss 
{
	
	public static void main(String[] args) 
	{
		List<Integer> s=new ArrayList<Integer>();
		s.add(23);
		s.add(1);
		s.add(12);
		s.add(2);
		Collections.sort(s);
		System.out.println(s);
		s.set(2, 3);
		System.out.println(s);
	}
}
