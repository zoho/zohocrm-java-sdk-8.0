package com.zoho.crm.api.features;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Limit implements Model
{
	private Integer total;

	private Integer editionLimit;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of total
	 * @return An Integer representing the total
	 */
	public Integer getTotal()
	{
		return  this.total;

	}

	/**
	 * The method to set the value to total
	 * @param total An Integer representing the total
	 */
	public void setTotal(Integer total)
	{
		 this.total = total;

		 this.keyModified.put("total", 1);

	}

	/**
	 * The method to get the value of editionLimit
	 * @return An Integer representing the editionLimit
	 */
	public Integer getEditionLimit()
	{
		return  this.editionLimit;

	}

	/**
	 * The method to set the value to editionLimit
	 * @param editionLimit An Integer representing the editionLimit
	 */
	public void setEditionLimit(Integer editionLimit)
	{
		 this.editionLimit = editionLimit;

		 this.keyModified.put("edition_limit", 1);

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