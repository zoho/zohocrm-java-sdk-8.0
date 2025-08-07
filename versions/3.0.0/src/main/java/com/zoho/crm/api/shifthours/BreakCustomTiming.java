package com.zoho.crm.api.shifthours;

import com.zoho.crm.api.util.Model;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class BreakCustomTiming implements Model
{
	private String days;

	private List<LocalTime> breakTiming;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of days
	 * @return A String representing the days
	 */
	public String getDays()
	{
		return  this.days;

	}

	/**
	 * The method to set the value to days
	 * @param days A String representing the days
	 */
	public void setDays(String days)
	{
		 this.days = days;

		 this.keyModified.put("days", 1);

	}

	/**
	 * The method to get the value of breakTiming
	 * @return An instance of List<LocalTime>
	 */
	public List<LocalTime> getBreakTiming()
	{
		return  this.breakTiming;

	}

	/**
	 * The method to set the value to breakTiming
	 * @param breakTiming An instance of List<LocalTime>
	 */
	public void setBreakTiming(List<LocalTime> breakTiming)
	{
		 this.breakTiming = breakTiming;

		 this.keyModified.put("break_timing", 1);

	}

	/**
	 * The method to check if the user has modified the given key
	 * @param key A String representing the key
	 * @return An Integer representing the modification
	 */
	public Integer isKeyModified(String key)
	{
		if((( this.keyModified.containsKey(key))))
		{
			return  this.keyModified.get(key);

		}
		return null;

	}

	/**
	 * The method to mark the given key as modified
	 * @param key A String representing the key
	 * @param modification An Integer representing the modification
	 */
	public void setKeyModified(String key, Integer modification)
	{
		 this.keyModified.put(key, modification);

	}
}