package com.caogemini.intefaces.mod1;

public class Son implements Father1,Father2
{
	public void home() 
	{
		Father2.super.home();
	}
	public static void main(String[] args) 
	{
		Son obj=new Son();
		obj.home();
	}
}
