package com.capgemini.thread.crreatingthread;

public class Main2 
{
	public static void main(String[] args) 
	{
		System.out.println("start");
		Thread2 t=new Thread2();
		Thread t2=new Thread(t);
		t2.start();
		System.out.println("endh");
	}
}
