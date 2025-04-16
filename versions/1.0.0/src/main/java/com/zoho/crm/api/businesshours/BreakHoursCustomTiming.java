package com.zoho.crm.api.businesshours;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BreakHoursCustomTiming implements Model
{
	private Choice<String> days;

	private List<String> businessTiming;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of days
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getDays()
	{
		return  this.days;

	}

	/**
	 * The method to set the value to days
	 * @param days An instance of Choice<String>
	 */
	public void setDays(Choice<String> days)
	{
		 this.days = days;

		 this.keyModified.put("days", 1);

	}

	/**
	 * The method to get the value of businessTiming
	 * @return An instance of List<String>
	 */
	public List<String> getBusinessTiming()
	{
		return  this.businessTiming;

	}

	/**
	 * The method to set the value to businessTiming
	 * @param businessTiming An instance of List<String>
	 */
	public void setBusinessTiming(List<String> businessTiming)
	{
		 this.businessTiming = businessTiming;

		 this.keyModified.put("business_timing", 1);

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