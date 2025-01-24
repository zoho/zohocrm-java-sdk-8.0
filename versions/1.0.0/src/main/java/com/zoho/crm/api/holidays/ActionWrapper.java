package com.zoho.crm.api.holidays;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ActionWrapper implements Model, ActionHandler
{
	private List<ActionResponse> holidays;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of holidays
	 * @return An instance of List<ActionResponse>
	 */
	public List<ActionResponse> getHolidays()
	{
		return  this.holidays;

	}

	/**
	 * The method to set the value to holidays
	 * @param holidays An instance of List<ActionResponse>
	 */
	public void setHolidays(List<ActionResponse> holidays)
	{
		 this.holidays = holidays;

		 this.keyModified.put("holidays", 1);

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