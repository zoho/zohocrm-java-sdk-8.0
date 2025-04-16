package com.zoho.crm.api.cadences;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ResponseWrapper implements Model, ResponseHandler
{
	private List<Cadences> cadences;

	private Info info;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of cadences
	 * @return An instance of List<Cadences>
	 */
	public List<Cadences> getCadences()
	{
		return  this.cadences;

	}

	/**
	 * The method to set the value to cadences
	 * @param cadences An instance of List<Cadences>
	 */
	public void setCadences(List<Cadences> cadences)
	{
		 this.cadences = cadences;

		 this.keyModified.put("cadences", 1);

	}

	/**
	 * The method to get the value of info
	 * @return An instance of Info
	 */
	public Info getInfo()
	{
		return  this.info;

	}

	/**
	 * The method to set the value to info
	 * @param info An instance of Info
	 */
	public void setInfo(Info info)
	{
		 this.info = info;

		 this.keyModified.put("info", 1);

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