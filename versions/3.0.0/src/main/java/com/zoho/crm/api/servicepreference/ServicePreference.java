package com.zoho.crm.api.servicepreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ServicePreference implements Model
{
	private Boolean jobSheetEnabled;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of jobSheetEnabled
	 * @return A Boolean representing the jobSheetEnabled
	 */
	public Boolean getJobSheetEnabled()
	{
		return  this.jobSheetEnabled;

	}

	/**
	 * The method to set the value to jobSheetEnabled
	 * @param jobSheetEnabled A Boolean representing the jobSheetEnabled
	 */
	public void setJobSheetEnabled(Boolean jobSheetEnabled)
	{
		 this.jobSheetEnabled = jobSheetEnabled;

		 this.keyModified.put("job_sheet_enabled", 1);

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