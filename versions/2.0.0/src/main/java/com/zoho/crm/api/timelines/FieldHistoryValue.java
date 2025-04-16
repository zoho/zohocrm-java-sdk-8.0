package com.zoho.crm.api.timelines;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class FieldHistoryValue implements Model
{
	private String new1;

	private String old;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of new
	 * @return A String representing the new1
	 */
	public String getNew()
	{
		return  this.new1;

	}

	/**
	 * The method to set the value to new
	 * @param new1 A String representing the new1
	 */
	public void setNew(String new1)
	{
		 this.new1 = new1;

		 this.keyModified.put("new", 1);

	}

	/**
	 * The method to get the value of old
	 * @return A String representing the old
	 */
	public String getOld()
	{
		return  this.old;

	}

	/**
	 * The method to set the value to old
	 * @param old A String representing the old
	 */
	public void setOld(String old)
	{
		 this.old = old;

		 this.keyModified.put("old", 1);

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