package com.caogemini.intefaces.mod1;

public class TestToyato extends RobertBosch 
{

	public void engine() 
	{
		System.out.println("Engine is dsigned");
	}

	public static void main(String[] args) 
	{
		TestToyato obj=new TestToyato();
		obj.desgin();
		obj.engine();
	}

}
