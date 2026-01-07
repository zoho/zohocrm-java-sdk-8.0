package com.zoho.crm.api.tags;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class AssociatedPlaces implements Model
{
	private String type;

	private List<String> resources;

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
	 * The method to get the value of resources
	 * @return An instance of List<String>
	 */
	public List<String> getResources()
	{
		return  this.resources;

	}

	/**
	 * The method to set the value to resources
	 * @param resources An instance of List<String>
	 */
	public void setResources(List<String> resources)
	{
		 this.resources = resources;

		 this.keyModified.put("resources", 1);

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