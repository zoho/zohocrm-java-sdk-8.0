package com.zoho.crm.api.recyclebin;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class RestoreAllRecords implements Model
{
	private Choice<Boolean> restoreAllRecords;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of restoreAllRecords
	 * @return An instance of Choice<Boolean>
	 */
	public Choice<Boolean> getRestoreAllRecords()
	{
		return  this.restoreAllRecords;

	}

	/**
	 * The method to set the value to restoreAllRecords
	 * @param restoreAllRecords An instance of Choice<Boolean>
	 */
	public void setRestoreAllRecords(Choice<Boolean> restoreAllRecords)
	{
		 this.restoreAllRecords = restoreAllRecords;

		 this.keyModified.put("restore_all_records", 1);

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