import java.util.function.*;

public class TestA 
{
	public static void main(String[] args) 
	{
		System.out.println("------------------Prediacte----------------");
		Predicate<Integer> p=i->i%2==0;
		boolean b=p.test(12);
		System.out.println(b);
		System.out.println(p.test(45));
		
		System.out.println("-------------------function---------------");
		Function<Integer, Integer> f1=i->i*100;
		int a=f1.apply(20);
		System.out.println(a);
		
		System.out.println("---------------------supplier-------------");
		Supplier<Person> s1=()->new Person(23,"anu");
		
		System.out.println(s1.get().getAge());
		System.out.println(s1.get().getName());
		
		System.out.println("-----------------------consumer------------");
		
		Consumer<Person> c1=j->{
			System.out.println(j.getAge());
			System.out.println(j.getName());
		};
		Person w=new Person(23,"rohan");
		c1.accept(w);
	}	
}
