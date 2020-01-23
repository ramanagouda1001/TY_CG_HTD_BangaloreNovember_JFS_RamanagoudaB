package com.capgemini.forestmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.bean.Land;
import com.capgemini.forestmanagement.exception.ForestManagementException;
import com.capgemini.forestmanagement.validation.Validation;

public class LandController {
		public static void main(String args[]){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean status = true;
		boolean flag =true;
		while(true)
		{
			String choice;
			System.out.println("---------Welcome Admin-------------");
			while (status == true) {
				System.out.println("Press 1 to Add the Land Details");
				System.out.println("Press 2 to Delete the Land Details");
				System.out.println("press 3 to Get all Details");
				System.out.println("press 4 to Back");
				System.out.println("enter the choice");
				choice = input.next();
				status = true;
				switch(Validation.isNumber2(choice))
				{
					case 1:
						Land land=new Land();
						flag = true;
						while (flag == true) {
							System.out.println("Enter the Land Number");
							String landNo=input.next();
							if (Validation.isNumber(landNo)) {
								int landNumber = Integer.parseInt(landNo);
								land.setNumber(landNumber);
								flag = false;
							} else {
								System.err.println("Only number is allowed");
							}
						}
						flag = true;
						while (flag == true) {
							System.out.println("Enter the Land Area");
							String area=input.next();
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
							String name=input.next();
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
							String region=input.next();
							if (Validation.isString(region)) {
								land.setRegion(region);
								flag = false;
							} else {
								System.err.println("Alphabets is allowed");
							}
						}
						flag = true;
						while (flag == true) {
							System.out.println("Enter the forest type");
							System.out.println("1.Coniferous");
							System.out.println("2.Borad leaved");
							System.out.println("3.Mixed");
							String forest_type=input.next();
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
							if(AdminController.landServices.addLand(land))
							{
								System.out.println("Added");
							}
							else
							{
								System.out.println("Not added");
							}
						} catch (ForestManagementException e) {
							System.err.println(e.getMessage());
						}
						break;
					case 2:
						int landNumber = 0;
						flag = true;
						while (flag == true) {
							System.out.println("Enter the Land Number");
							String landNo=input.next();
							if (Validation.isNumber(landNo)) {
								landNumber = Integer.parseInt(landNo);
								flag = false;
							} else {
								System.err.println("Only number is allowed");
							}
						}
						try {
							if(AdminController.landServices.deleteLand(landNumber))
							{
								System.out.println("deleted");
							}
							else
							{
								System.out.println("not deleted");
							}
						} catch (ForestManagementException e) {
							System.err.println(e.getMessage());
						}
						break;
					case 3:
						List<Land> list=AdminController.landServices.displayLand();
						try {
							if(list==null)
							{
								System.out.println("empty");
								
							}
							else
							{
								System.out.println(list);
							}
						} catch (ForestManagementException e) {
							System.err.println(e.getMessage());
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
