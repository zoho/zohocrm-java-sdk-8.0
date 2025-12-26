package com.zoho.crm.api.unsubscribelinks;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AssociatedPlaces implements Model
{
	private String type;

	private Resource resource;

	private Detail details;

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
	 * The method to get the value of details
	 * @return An instance of Detail
	 */
	public Detail getDetails()
	{
		return  this.details;

	}

	/**
	 * The method to set the value to details
	 * @param details An instance of Detail
	 */
	public void setDetails(Detail details)
	{
		 this.details = details;

		 this.keyModified.put("details", 1);

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