package com.zoho.crm.api.callpreferences;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ResponseWrapper implements Model, ResponseHandler
{
	private CallPreferences callPreferences;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of callPreferences
	 * @return An instance of CallPreferences
	 */
	public CallPreferences getCallPreferences()
	{
		return  this.callPreferences;

	}

	/**
	 * The method to set the value to callPreferences
	 * @param callPreferences An instance of CallPreferences
	 */
	public void setCallPreferences(CallPreferences callPreferences)
	{
		 this.callPreferences = callPreferences;

		 this.keyModified.put("call_preferences", 1);

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