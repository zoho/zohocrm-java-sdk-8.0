package com.zoho.crm.api.picklistvalues;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ResponseWrapper implements Model, ResponseHandler
{
	private List<PickListValues> pickListValues;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of pickListValues
	 * @return An instance of List<PickListValues>
	 */
	public List<PickListValues> getPickListValues()
	{
		return  this.pickListValues;

	}

	/**
	 * The method to set the value to pickListValues
	 * @param pickListValues An instance of List<PickListValues>
	 */
	public void setPickListValues(List<PickListValues> pickListValues)
	{
		 this.pickListValues = pickListValues;

		 this.keyModified.put("pick_list_values", 1);

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