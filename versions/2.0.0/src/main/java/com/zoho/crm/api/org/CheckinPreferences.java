package com.zoho.crm.api.org;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class CheckinPreferences implements Model
{
	private String restrictedEventTypes;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of restrictedEventTypes
	 * @return A String representing the restrictedEventTypes
	 */
	public String getRestrictedEventTypes()
	{
		return  this.restrictedEventTypes;

	}

	/**
	 * The method to set the value to restrictedEventTypes
	 * @param restrictedEventTypes A String representing the restrictedEventTypes
	 */
	public void setRestrictedEventTypes(String restrictedEventTypes)
	{
		 this.restrictedEventTypes = restrictedEventTypes;

		 this.keyModified.put("restricted_event_types", 1);

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