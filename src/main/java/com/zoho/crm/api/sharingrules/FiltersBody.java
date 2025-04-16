package com.zoho.crm.api.sharingrules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class FiltersBody implements Model
{
	private List<Criteria> filters;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of filters
	 * @return An instance of List<Criteria>
	 */
	public List<Criteria> getFilters()
	{
		return  this.filters;

	}

	/**
	 * The method to set the value to filters
	 * @param filters An instance of List<Criteria>
	 */
	public void setFilters(List<Criteria> filters)
	{
		 this.filters = filters;

		 this.keyModified.put("filters", 1);

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