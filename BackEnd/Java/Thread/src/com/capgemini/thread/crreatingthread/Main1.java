package com.capgemini.thread.crreatingthread;

public class Main1 
{
	public static void main(String[] args)
	{
		System.out.println("before");
		Thread1 t=new Thread1();
		t.start();
		System.out.println("after");
	}
}
