import java.util.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Application 
{
	public static void main(String[] args) 
	{
		LinkedList<Integer> a=new LinkedList<Integer>();
		a.add(24);
		a.add(36);
		a.add(23);
		a.add(45);
		a.add(89);
		a.add(90);
		List l=a.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(l);
		
		List l1=a.stream().filter(i->i%2!=0).collect(Collectors.toList());
		System.out.println(l1);
		
		List l2=a.stream().map(i->i*100).collect(Collectors.toList());
		System.out.println(l2);
		
		Optional<Integer> q=a.stream().max((i,j)->i.compareTo(j));
		System.out.println(q);
		
		System.out.println(a.stream().count());
	}
}
