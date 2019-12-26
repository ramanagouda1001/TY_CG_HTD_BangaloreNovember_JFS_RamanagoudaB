package com.caogemini.intefaces.mod1;
public class Lamdaexpr1 
{
//	lamdaexpr v=()->{
//		System.out.println("hello");// lamda expression for zero parameter 
//	};

//	lamdaexpr v= a->{
//		System.out.println("hello");// lamda expression for one parameter 
//	};
	
	lamdaexpr v=(a,b)->{
		System.out.println("hello");
	};
	public static void main(String[] args) 
	{
		Lamdaexpr1 obj=new Lamdaexpr1();
		obj.v.eat(2,4);
	}
}
