package com.zoho.crm.api.features;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Detail implements Model
{
	private Limit availableCount;

	private Limit limits;

	private Limit usedCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of availableCount
	 * @return An instance of Limit
	 */
	public Limit getAvailableCount()
	{
		return  this.availableCount;

	}

	/**
	 * The method to set the value to availableCount
	 * @param availableCount An instance of Limit
	 */
	public void setAvailableCount(Limit availableCount)
	{
		 this.availableCount = availableCount;

		 this.keyModified.put("available_count", 1);

	}

	/**
	 * The method to get the value of limits
	 * @return An instance of Limit
	 */
	public Limit getLimits()
	{
		return  this.limits;

	}

	/**
	 * The method to set the value to limits
	 * @param limits An instance of Limit
	 */
	public void setLimits(Limit limits)
	{
		 this.limits = limits;

		 this.keyModified.put("limits", 1);

	}

	/**
	 * The method to get the value of usedCount
	 * @return An instance of Limit
	 */
	public Limit getUsedCount()
	{
		return  this.usedCount;

	}

	/**
	 * The method to set the value to usedCount
	 * @param usedCount An instance of Limit
	 */
	public void setUsedCount(Limit usedCount)
	{
		 this.usedCount = usedCount;

		 this.keyModified.put("used_count", 1);

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