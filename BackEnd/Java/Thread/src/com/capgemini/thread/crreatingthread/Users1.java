package com.capgemini.thread.crreatingthread;

public class Users1 extends Thread
{
	IRCTC i;

	public Users1(IRCTC i) {
		super();
		this.i = i;
	}
	@Override
	public void run() 
	{
		i.confirmTicket();
	}
}
