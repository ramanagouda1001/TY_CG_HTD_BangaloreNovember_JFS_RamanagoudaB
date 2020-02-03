package com.cagemini.forestmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.cagemini.forestmanagement.bean.Land;
import com.cagemini.forestmanagement.exception.ForestManagementSystem;
import com.cagemini.forestmanagement.factory.LandFactory;
import com.cagemini.forestmanagement.service.LandServices;
import com.cagemini.forestmanagement.validation.Validation;

public class LandController {
	public static LandServices services=LandFactory.instanceofLandServices();
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean flag =true;
		while(true)
		{
			flag = true;
			String choice;
			System.out.println("---------Welcome Admin-------------");
			System.out.println("Press 1 to Add the Land Details");
			System.out.println("Press 2 to Delete the Land Details");
			System.out.println("press 3 to Get all Details");
			System.out.println("press 4 to Back");
			System.out.println("enter the choice");
			choice = in.next();
			switch(Validation.isNumber2(choice))
				{
				case 1:
					Land land=new Land();
					flag = true;
					while (flag == true) {
						System.out.println("Enter the Land Number");
						String landNo=in.next();
						if (Validation.isNumber(landNo)) {
							if(Validation.validateLength(landNo))
							{
								int landNumber = Integer.parseInt(landNo);
								land.setNumber(landNumber);
								flag = false;
							}
							else
							{
								System.err.println("Only four digit is allowed");
							}
						} else {
							System.err.println("Only number is allowed");
						}
					}
					flag = true;
					while (flag == true) {
						System.out.println("Enter the Land Area(Sq cm)");
						String area=in.next();
						if (Validation.isNumber(area)) {
							int areaNumber = Integer.parseInt(area);
							land.setArea(areaNumber);
							flag = false;
						} else {
							System.err.println("Only number is allowed");
						}
					}
					flag = true;
					while (flag == true) {
						System.out.println("Enter the Name of the land");
						String name=in.next();
						if (Validation.isString(name)) {
							land.setName(name);
							flag = false;
						} else {
							System.err.println("Alphabets is allowed");
						}
					}
					flag = true;
					while (flag == true) {
						System.out.println("Enter the region of land");
						System.out.println("1.North");
						System.out.println("2.East");
						System.out.println("3.South");
						System.out.println("4.west");
						String regionChoice=in.next();
						switch(Validation.isNumber2(regionChoice))
						{
						case 1:
							land.setRegion("North");
							flag=false;
						break;
						case 2:
							land.setRegion("East");
							flag=false;
							break;
						case 3:
							land.setRegion("south");
							flag=false;
						break;
						case 4:
							land.setRegion("west");
							flag=false;
						break;
						default:
							System.err.println("invalid choice");
						}		
					}
					flag = true;
					while (flag == true) {
						System.out.println("Enter the forest type");
						System.out.println("1.Coniferous");
						System.out.println("2.Borad leaved");
						System.out.println("3.Mixed");
						String forest_type=in.next();
						switch(Validation.isNumber2(forest_type))
						{
							case 1:
								land.setForestType("Coniferous");
								flag=false;
							break;
							case 2:
								land.setForestType("Bored leaved");
								flag=false;
							break;
							case 3:
								land.setForestType("mixed");
								flag=false;
								break;
							default:
								System.out.println("invalid input");
						}
					}
					try {
						if(services.addLand(land))
						{
							System.out.println("Land Details Are Added");
						}
						else
						{
							System.err.println("Not added");
						}
					}
					catch(ForestManagementSystem e)
					{
						System.err.println(e.getMessage());
					}
					break;
					case 2:
						int landNumber = 0;
						flag = true;
						while (flag == true) {
							System.out.println("Enter the Land Number");
							String landNo=in.next();
							if (Validation.isNumber(landNo)) {
								if(Validation.validateLength(landNo))
								{
									landNumber = Integer.parseInt(landNo);
									flag = false;
								}
								else
								{
									System.err.println("Only four digit is allowed");
								}
							} else {
								System.err.println("Only number is allowed");
							}
						}
						try {
							if(services.deleteLand(landNumber))
							{
								System.out.println("deleted");
							}
							else
							{
								System.out.println("not deleted");
							}
						} catch (ForestManagementSystem e) {
							System.err.println(e.getMessage());
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
						System.err.println("invalid Choice");
				}
			}
	}
}

