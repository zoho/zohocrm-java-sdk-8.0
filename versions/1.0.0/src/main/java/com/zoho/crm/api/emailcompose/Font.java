package com.zoho.crm.api.emailcompose;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Font implements Model
{
	private Integer size;

	private String family;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of size
	 * @return An Integer representing the size
	 */
	public Integer getSize()
	{
		return  this.size;

	}

	/**
	 * The method to set the value to size
	 * @param size An Integer representing the size
	 */
	public void setSize(Integer size)
	{
		 this.size = size;

		 this.keyModified.put("size", 1);

	}

	/**
	 * The method to get the value of family
	 * @return A String representing the family
	 */
	public String getFamily()
	{
		return  this.family;

	}

	/**
	 * The method to set the value to family
	 * @param family A String representing the family
	 */
	public void setFamily(String family)
	{
		 this.family = family;

		 this.keyModified.put("family", 1);

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