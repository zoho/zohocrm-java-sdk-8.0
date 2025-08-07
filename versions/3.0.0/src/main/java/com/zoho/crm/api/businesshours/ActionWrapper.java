package com.zoho.crm.api.businesshours;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ActionWrapper implements Model, ActionHandler
{
	private ActionResponse businessHours;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of businessHours
	 * @return An instance of ActionResponse
	 */
	public ActionResponse getBusinessHours()
	{
		return  this.businessHours;

	}

	/**
	 * The method to set the value to businessHours
	 * @param businessHours An instance of ActionResponse
	 */
	public void setBusinessHours(ActionResponse businessHours)
	{
		 this.businessHours = businessHours;

		 this.keyModified.put("business_hours", 1);

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