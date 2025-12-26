package com.zoho.crm.api.layouts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Delete1 implements Model
{
	private Boolean permanent;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of permanent
	 * @return A Boolean representing the permanent
	 */
	public Boolean getPermanent()
	{
		return  this.permanent;

	}

	/**
	 * The method to set the value to permanent
	 * @param permanent A Boolean representing the permanent
	 */
	public void setPermanent(Boolean permanent)
	{
		 this.permanent = permanent;

		 this.keyModified.put("permanent", 1);

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