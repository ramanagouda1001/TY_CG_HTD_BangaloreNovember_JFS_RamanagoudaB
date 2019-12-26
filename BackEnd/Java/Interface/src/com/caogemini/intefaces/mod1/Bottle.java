package com.caogemini.intefaces.mod1;

public interface Bottle 
{
	void open();
	void drink();
	default void jucie()
	{
		System.out.println("juice is opened");
	}
	static void close()
	{
		System.out.println("closing the juice");
	}
}
