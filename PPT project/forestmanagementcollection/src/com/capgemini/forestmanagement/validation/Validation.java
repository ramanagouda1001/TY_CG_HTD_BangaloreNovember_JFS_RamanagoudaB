package com.capgemini.forestmanagement.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validation{

	public static boolean isString(String a) {

		return ((!a.equals("")) 
	            && (a != null) 
	            && (a.matches("^[a-zA-Z]*$")));
	}

	public static String validateWeeks(String s) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy",java.util.Locale.ENGLISH);
		Date mydate;
		try {
			mydate = sdf.parse(s);
			sdf.applyPattern("EEEEE");
			String myDateString=sdf.format(mydate);
			return myDateString;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static int isNumber2(String s) {
		try {
			int result = Integer.parseInt(s);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}

	public static boolean validateLength(String s) {
		return Pattern.matches("[0-9]{4}", s);
	}

	public static boolean validateAlpaLength(String s) {
		return Pattern.matches("[a-zA-Z]{2}[0-9]{2}", s);
	}

	public static boolean validateMonth(String date) {
		String month = date.substring(3, 5);
		String day = date.substring(0, 2);
		String year = date.substring(6, 10);
		if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
			if (day.equals("31"))
				return false;
			else
				return true;
		} else if (month.equals("02")) {
			if (day.equals("31") || day.equals("30")) {
				return false;
			}
			if ((Integer.parseInt(year) % 4) == 0) {
				if (day.equals("29"))
					return true;
				else
					return true;
			} else {
				return true;
			}

		} else {
			return true;
		}
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean validateLengthOfPostal(String s) {
		return Pattern.matches("[0-9]{5}", s);
	}

	public static boolean validateLengthOfTelephone(String s) {
		return Pattern.matches("[0-9]{6}", s);
	}
	public static boolean validPassword(String password) {
		return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,}$", password);
	}

	public static boolean validweek(String s)
	{
			String finalDay=null;
			SimpleDateFormat fomat1=new SimpleDateFormat("dd/mm/yyy");
			try {
				Date dt1=fomat1.parse(s);
				DateFormat format2=new SimpleDateFormat("EEEE");
				finalDay=format2.format(dt1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(s.equalsIgnoreCase(finalDay))
				return true;
			else
				return false;
			
	}
}
