package com.zoho.crm.api.backup;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class UrlsWrapper implements Model, ResponseHandler
{
	private Urls urls;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of urls
	 * @return An instance of Urls
	 */
	public Urls getUrls()
	{
		return  this.urls;

	}

	/**
	 * The method to set the value to urls
	 * @param urls An instance of Urls
	 */
	public void setUrls(Urls urls)
	{
		 this.urls = urls;

		 this.keyModified.put("urls", 1);

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