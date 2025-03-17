package com.zoho.crm.api.functions;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.Map;

public class BodyWrapper implements Model
{
	private Map<String, Object> body;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of body
	 * @return An instance of Map<String,Object>
	 */
	public Map<String, Object> getBody()
	{
		return  this.body;

	}

	/**
	 * The method to set the value to body
	 * @param body An instance of Map<String,Object>
	 */
	public void setBody(Map<String, Object> body)
	{
		 this.body = body;

		 this.keyModified.put("body", 1);

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