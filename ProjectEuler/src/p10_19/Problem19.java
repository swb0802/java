/*
 * How many Sundays fell on the first of the month during the 
 * twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * */

package p10_19;

public class Problem19 {

	public static void main(String args[])
	{
		MyCalendar mc = new MyCalendar();
		while(mc.getYear() != 1901)
		{
			mc.nextDay();
		}
		
		int count = 0;
		while(mc.getYear() != 2001)
		{
			if(mc.getDayOfWeek() == 7 && mc.getDay() == 1)
			{
				count++;
			}
			mc.nextDay();
		}
		System.out.println(count);
	}
}


class MyCalendar
{
	private int year;
	private int month;
	private int day;
	private int dayOfWeek;
	
	public MyCalendar()
	{
		year = 1900;
		month = 1;
		day = 1;
		dayOfWeek = 1; //Monday
	}
	
	public boolean isLeapYear(int y)
	{
		if(y % 100 != 0 && y % 4 == 0 
				|| y % 100 == 0 && y % 400 == 0)
		{
			return true;
		}
		return false;
	}
	
	public void nextDay()
	{
		day++;
		switch(month)
		{
		case 1: case 3: case 5: case 7 : case 8: case 10:
			if(day == 32)
			{
				month++;
				day = 1;
			}
			break;
		 case 12:
			 if(day == 32)
			 {
				 month = 1;
				 day = 1;
				 year++;
			 }
			 break;
		case 4: case 6: case 9: case 11:
			if(day == 31)
			{
				month++;
				day = 1;
			}
			break;
		case 2:
			if(isLeapYear(year) && day == 30 
			|| !isLeapYear(year) && day == 29)
			{
				month = 3;
				day = 1;
			}
			break;
		default:
			break;
		}
		dayOfWeek = dayOfWeek % 7 + 1;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	
}




