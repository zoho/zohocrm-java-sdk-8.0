package com.zoho.crm.api.ziaorgenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Description implements Model
{
	private String title;

	private String description;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of title
	 * @return A String representing the title
	 */
	public String getTitle()
	{
		return  this.title;

	}

	/**
	 * The method to set the value to title
	 * @param title A String representing the title
	 */
	public void setTitle(String title)
	{
		 this.title = title;

		 this.keyModified.put("title", 1);

	}

	/**
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.description = description;

		 this.keyModified.put("description", 1);

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