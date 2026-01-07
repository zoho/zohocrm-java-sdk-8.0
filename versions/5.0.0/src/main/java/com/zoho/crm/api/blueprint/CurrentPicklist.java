package com.zoho.crm.api.blueprint;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class CurrentPicklist implements Model
{
	private String colourCode;

	private String id;

	private String value;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of colourCode
	 * @return A String representing the colourCode
	 */
	public String getColourCode()
	{
		return  this.colourCode;

	}

	/**
	 * The method to set the value to colourCode
	 * @param colourCode A String representing the colourCode
	 */
	public void setColourCode(String colourCode)
	{
		 this.colourCode = colourCode;

		 this.keyModified.put("colour_code", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

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