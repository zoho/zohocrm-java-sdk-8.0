package com.zoho.crm.api.layouts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class SubformProperty implements Model
{
	private Boolean pinnedColumn;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of pinnedColumn
	 * @return A Boolean representing the pinnedColumn
	 */
	public Boolean getPinnedColumn()
	{
		return  this.pinnedColumn;

	}

	/**
	 * The method to set the value to pinnedColumn
	 * @param pinnedColumn A Boolean representing the pinnedColumn
	 */
	public void setPinnedColumn(Boolean pinnedColumn)
	{
		 this.pinnedColumn = pinnedColumn;

		 this.keyModified.put("pinned_column", 1);

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