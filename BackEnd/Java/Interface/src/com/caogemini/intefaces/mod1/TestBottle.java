package com.caogemini.intefaces.mod1;
public class TestBottle 
{
	public static void main(String[] args) 
	{
		Peps p1=new Peps();
		Fanta f1=new Fanta();
		p1.drink();
		p1.open();
		f1.drink();
		f1.open();
		p1.jucie();
		Bottle.close();
	}
}
