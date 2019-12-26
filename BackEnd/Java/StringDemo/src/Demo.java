public class Demo 
{
	public static void main(String[] args) 
	{
		System.out.println("-----String--------");
		String s=new String("rohan");
		System.out.println(s.hashCode());
		s=s.concat(" Biradar");
		System.out.println(s.hashCode());
		System.out.println("-----StringBuffer-----------");
		
		StringBuffer s1=new StringBuffer("Rama");
		System.out.println(s1.hashCode());
		s1=s1.append("nagouda");
		System.out.println(s1.hashCode());
		System.out.println("-----StringBuilder----------");
		
		StringBuilder s2=new StringBuilder("rohan");
		System.out.println(s2.hashCode());
		s2=s2.append(" Biradar");
		System.out.println(s2.hashCode());
	}
}
