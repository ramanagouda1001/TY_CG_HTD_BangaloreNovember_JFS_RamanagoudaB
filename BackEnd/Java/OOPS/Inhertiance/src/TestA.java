
public class TestA 
{
	public static void main(String[] args) 
	{
//		FirstGeneration f1=new FirstGeneration();
//		f1.call();
//		f1.msg();
//		SecondGeneration s1=new SecondGeneration();
//		s1.call();
//		s1.msg();
//		s1.radio();
//		ThridGeneration t1=new ThridGeneration();
//		t1.call();
//		t1.msg();
//		t1.radio();
//		t1.camera();
		
		FirstGeneration fg=new SecondGeneration();
		fg.call();
		fg.msg();
		
		SecondGeneration sg=new ThridGeneration();
		sg.call();
		sg.msg();
		sg.radio();
		
		ThridGeneration tg=new ThridGeneration();
		tg.call();
		tg.msg();
		tg.radio();
		tg.camera();
	}
}
