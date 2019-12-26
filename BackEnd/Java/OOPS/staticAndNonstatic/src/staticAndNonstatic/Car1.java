package staticAndNonstatic;
public class Car1 extends Vehicle
{
	int cost=20000;
	void carDetails()
	{
		int cost=10000;
		System.out.println("the value of local vaiable is "+cost);
		System.out.println("the value of global variable is "+this.cost);// this used to call member variable
		System.out.println("the parent value is "+super.cost);// super is used to call parent variable
	}
}
