package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class DoubleOptinEmailTemplate implements Model
{
	private FromAddress fromAddress;

	private String content;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of fromAddress
	 * @return An instance of FromAddress
	 */
	public FromAddress getFromAddress()
	{
		return  this.fromAddress;

	}

	/**
	 * The method to set the value to fromAddress
	 * @param fromAddress An instance of FromAddress
	 */
	public void setFromAddress(FromAddress fromAddress)
	{
		 this.fromAddress = fromAddress;

		 this.keyModified.put("from_address", 1);

	}

	/**
	 * The method to get the value of content
	 * @return A String representing the content
	 */
	public String getContent()
	{
		return  this.content;

	}

	/**
	 * The method to set the value to content
	 * @param content A String representing the content
	 */
	public void setContent(String content)
	{
		 this.content = content;

		 this.keyModified.put("content", 1);

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