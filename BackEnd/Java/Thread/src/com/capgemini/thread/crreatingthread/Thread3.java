package com.capgemini.thread.crreatingthread;

public class Thread3 
{
	public static void main(String[] args) 
	{
		System.out.println("start");
		PVR p=new PVR();
		User s=new User(p);
		s.start();
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			
		}
		p.leaveme();
		
		System.out.println("end");
	}
}
