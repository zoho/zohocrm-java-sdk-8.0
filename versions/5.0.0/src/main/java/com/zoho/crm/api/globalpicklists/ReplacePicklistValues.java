package com.zoho.crm.api.globalpicklists;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ReplacePicklistValues implements Model
{
	private ReplacePicklistValue newValue;

	private ReplacePicklistValue oldValue;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of newValue
	 * @return An instance of ReplacePicklistValue
	 */
	public ReplacePicklistValue getNewValue()
	{
		return  this.newValue;

	}

	/**
	 * The method to set the value to newValue
	 * @param newValue An instance of ReplacePicklistValue
	 */
	public void setNewValue(ReplacePicklistValue newValue)
	{
		 this.newValue = newValue;

		 this.keyModified.put("new_value", 1);

	}

	/**
	 * The method to get the value of oldValue
	 * @return An instance of ReplacePicklistValue
	 */
	public ReplacePicklistValue getOldValue()
	{
		return  this.oldValue;

	}

	/**
	 * The method to set the value to oldValue
	 * @param oldValue An instance of ReplacePicklistValue
	 */
	public void setOldValue(ReplacePicklistValue oldValue)
	{
		 this.oldValue = oldValue;

		 this.keyModified.put("old_value", 1);

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