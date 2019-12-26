package staticAndNonstatic;
public class TestQspider 
{
	public static void main(String[] args) 
	{
		Qspider rajajinagar =new Qspider();
		rajajinagar.swipe();
		rajajinagar.swipe();
		Qspider BTM=new Qspider();
		BTM.swipe();
		System.out.println(rajajinagar.branchStudentCount);
		System.out.println(BTM.branchStudentCount);
		System.out.println(Qspider.totalStudentCount);
	}
}
