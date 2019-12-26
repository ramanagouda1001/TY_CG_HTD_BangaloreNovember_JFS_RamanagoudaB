package com.caogemini.intefaces.mod1;
public class Peps implements Bottle
{
	public void open() 
	{
		System.out.println("You Are opening Peps");
	}
	public void drink() 
	{
		System.out.println("You are Drinking Peps");
	}
	public void jucie()
	{
		System.out.println("juice is overridden");
	}

}
