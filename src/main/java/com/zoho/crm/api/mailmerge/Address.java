package com.zoho.crm.api.mailmerge;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Address implements Model
{
	private String type;

	private String value;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of value
	 * @return A String representing the value
	 */
	public String getValue()
	{
		return  this.value;

	}

	/**
	 * The method to set the value to value
	 * @param value A String representing the value
	 */
	public void setValue(String value)
	{
		 this.value = value;

		 this.keyModified.put("value", 1);

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