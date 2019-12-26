package com.capgemini.typecasting.pack1;

import java.util.Scanner;

public class Demo 
{
	public static void print(int n)
	{
		int m;
		if(n%5==0)
			m=n-1;
		else
			m=n;
		int count=0;
		if(m==0)
		{
			System.out.println(m+1);
		}
		else
		{
			for(int i=1;i<100;i++)
			{
				if(i%2==1)
				{
					System.out.print(i+" ");
					count++;
				}
				if(count==m)
					break;
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=in.nextInt();
		print(n);
	}

}
