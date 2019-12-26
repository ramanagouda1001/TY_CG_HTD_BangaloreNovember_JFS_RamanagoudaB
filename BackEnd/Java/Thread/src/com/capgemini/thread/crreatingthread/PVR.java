package com.capgemini.thread.crreatingthread;

public class PVR 
{
	 synchronized public void cofirmTicket()
	{
		 for (int i = 0; i <4; i++) {
			System.out.println(i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	synchronized void leaveme()
	 {
		System.out.println("notify called");
		 notify();
	 }

}
