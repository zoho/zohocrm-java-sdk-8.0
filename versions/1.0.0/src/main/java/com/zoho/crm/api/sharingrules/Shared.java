package com.zoho.crm.api.sharingrules;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Shared implements Model
{
	private Resource resource;

	private Boolean subordinates;

	private Choice<String> type;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of resource
	 * @return An instance of Resource
	 */
	public Resource getResource()
	{
		return  this.resource;

	}

	/**
	 * The method to set the value to resource
	 * @param resource An instance of Resource
	 */
	public void setResource(Resource resource)
	{
		 this.resource = resource;

		 this.keyModified.put("resource", 1);

	}

	/**
	 * The method to get the value of subordinates
	 * @return A Boolean representing the subordinates
	 */
	public Boolean getSubordinates()
	{
		return  this.subordinates;

	}

	/**
	 * The method to set the value to subordinates
	 * @param subordinates A Boolean representing the subordinates
	 */
	public void setSubordinates(Boolean subordinates)
	{
		 this.subordinates = subordinates;

		 this.keyModified.put("subordinates", 1);

	}

	/**
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

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