package com.zoho.crm.api.definition;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ResponseWrapper implements Model
{
	private Definition definition;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of definition
	 * @return An instance of Definition
	 */
	public Definition getDefinition()
	{
		return  this.definition;

	}

	/**
	 * The method to set the value to definition
	 * @param definition An instance of Definition
	 */
	public void setDefinition(Definition definition)
	{
		 this.definition = definition;

		 this.keyModified.put("definition", 1);

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