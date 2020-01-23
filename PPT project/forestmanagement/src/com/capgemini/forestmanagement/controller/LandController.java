package com.capgemini.forestmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Land;
import com.capgemini.forestmanagement.factory.LandFactory;
import com.capgemini.forestmanagement.service.LandServices;
import com.capgemini.forestmanagement.validation.Validation;

public class LandController {
	public static LandServices services=LandFactory.instanceofLandServices();
	public LandController() {
		Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		char check = 'y';
		char ch2 = 'y';
		char flag ='y';
		while(true)
		{
			flag = 'y';
			ch2 = 'y';
			String choice;
			System.out.println("---------Welcome Admin-------------");
			while (ch2 == 'y') {
				System.out.println("Press 1 to Add the Land Details");
				System.out.println("Press 2 to Delete the Land Details");
				System.out.println("press 3 to Get all Details");
				System.out.println("press 4 to Back");
				System.out.println("enter the choice");
				choice = in.next();
				ch2 = 'y';
				switch(Validation.isNumber2(choice))
				{
					case 1:
						Land land=new Land();
						flag = 'y';
						while (flag == 'y') {
							System.out.println("Enter the Land Number");
							String landNo=in.next();
							if (Validation.isNumber(landNo)) {
								int landNumber = Integer.parseInt(landNo);
								land.setNumber(landNumber);
								flag = 'n';
							} else {
								System.err.println("Only number is allowed");
							}
						}
						flag = 'y';
						while (flag == 'y') {
							System.out.println("Enter the Land Area");
							String area=in.next();
							if (Validation.isNumber(area)) {
								int areaNumber = Integer.parseInt(area);
								land.setArea(areaNumber);
								flag = 'n';
							} else {
								System.err.println("Only number is allowed");
							}
						}
						flag = 'y';
						while (flag == 'y') {
							System.out.println("Enter the Name of the land");
							String name=in.next();
							if (Validation.isString(name)) {
								land.setName(name);
								flag = 'n';
							} else {
								System.err.println("Alphabets is allowed");
							}
						}
						flag = 'y';
						while (flag == 'y') {
							System.out.println("Enter the region of land");
							String region=in.next();
							if (Validation.isString(region)) {
								land.setRegion(region);
								flag = 'n';
							} else {
								System.err.println("Alphabets is allowed");
							}
						}
						flag = 'y';
						while (flag == 'y') {
							System.out.println("Enter the forest type");
							System.out.println("1.Coniferous");
							System.out.println("2.Borad leaved");
							System.out.println("3.Mixed");
							String forest_type=in.next();
							switch(Validation.isNumber2(forest_type))
							{
								case 1:
									land.setForest_type("Coniferous");
									flag='n';
									break;
								case 2:
									land.setForest_type("Bored leaved");
									flag='n';
									break;
								case 3:
									land.setForest_type("mixed");
									flag='n';
									break;
								default:
									System.out.println("invalid input");
							}
						}
						if(services.addLand(land))
						{
							System.out.println("Added");
						}
						else
						{
							System.out.println("Not added");
						}
						break;
					case 2:
						int landNumber = 0;
						flag = 'y';
						while (flag == 'y') {
							System.out.println("Enter the Land Number");
							String landNo=in.next();
							if (Validation.isNumber(landNo)) {
								landNumber = Integer.parseInt(landNo);
								flag = 'n';
							} else {
								System.err.println("Only number is allowed");
							}
						}
						if(services.deleteLand(landNumber))
						{
							System.out.println("deleted");
						}
						else
						{
							System.out.println("not deleted");
						}
						break;
					case 3:
						List<Land> list=services.displayLand();
						if(list==null)
						{
							System.out.println("empty");
							
						}
						else
						{
							System.out.println(list);
						}
					break;
					case 4:
						return;
					default:
						System.out.println("invalid");
				}
			}

		}
	}
}
