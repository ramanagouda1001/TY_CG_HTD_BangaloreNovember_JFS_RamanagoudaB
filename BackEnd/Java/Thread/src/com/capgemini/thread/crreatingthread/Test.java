package com.capgemini.thread.crreatingthread;

public class Test 
{
	public static void main(String[] args) 
	{
		IRCTC i=new IRCTC();
		Users1 n=new Users1(i);
		n.start();

		Users1 m=new Users1(i);
		m.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i.leaveme();
	}
}
