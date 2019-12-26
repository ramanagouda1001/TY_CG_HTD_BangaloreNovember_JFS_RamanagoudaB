package com.capgemini.typecasting.pack1;
public class Primitive 
{
	public static void main(String[] args) 
	{
		byte b=4;
		int i=b;
		short s=b;
		long l=b;
		float f=b;
		double d=b;
		System.out.println("byte is ="+b);
		System.out.println("int is ="+i);
		System.out.println("short is ="+s);
		System.out.println("long is ="+l);
		System.out.println("float is ="+f);
		System.out.println("double is ="+d);
		System.out.println("---------------------");
		double pi=3.142;
		int in=(int) pi;
		int in2=45;
		char ch=(char) in2;
		System.out.println("the value of double is "+pi);
		System.out.println("the value of int is "+in);
		System.out.println(in2);
	}

}
