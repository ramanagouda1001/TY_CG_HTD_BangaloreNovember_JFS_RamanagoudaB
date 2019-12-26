package com.capgemini.typecasting.pack1;
public class Lion extends Animal 
{
	void run()
	{
		System.out.println("lion");
	}
	public static void main(String[] args) 
	{
		Animal a=new Dog();
		a.eat();
		
		Dog a1=(Dog) a;
		a1.eat();
		a1.run();
		
		Animal a2=new Lion();
		a2.eat();
		
		Lion l=(Lion) a2;
		l.run();
		l.eat();
	}
}
