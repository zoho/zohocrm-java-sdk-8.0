package com.zoho.crm.api.signalsnotifications;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Action implements Model
{
	private String type;

	private String openIn;

	private String displayName;

	private String url;

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
	 * The method to get the value of openIn
	 * @return A String representing the openIn
	 */
	public String getOpenIn()
	{
		return  this.openIn;

	}

	/**
	 * The method to set the value to openIn
	 * @param openIn A String representing the openIn
	 */
	public void setOpenIn(String openIn)
	{
		 this.openIn = openIn;

		 this.keyModified.put("open_in", 1);

	}

	/**
	 * The method to get the value of displayName
	 * @return A String representing the displayName
	 */
	public String getDisplayName()
	{
		return  this.displayName;

	}

	/**
	 * The method to set the value to displayName
	 * @param displayName A String representing the displayName
	 */
	public void setDisplayName(String displayName)
	{
		 this.displayName = displayName;

		 this.keyModified.put("display_name", 1);

	}

	/**
	 * The method to get the value of url
	 * @return A String representing the url
	 */
	public String getUrl()
	{
		return  this.url;

	}

	/**
	 * The method to set the value to url
	 * @param url A String representing the url
	 */
	public void setUrl(String url)
	{
		 this.url = url;

		 this.keyModified.put("url", 1);

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