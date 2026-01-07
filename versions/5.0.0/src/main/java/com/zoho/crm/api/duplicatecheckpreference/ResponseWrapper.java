package com.zoho.crm.api.duplicatecheckpreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ResponseWrapper implements Model, ResponseHandler
{
	private DuplicateCheckPreference duplicateCheckPreference;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of duplicateCheckPreference
	 * @return An instance of DuplicateCheckPreference
	 */
	public DuplicateCheckPreference getDuplicateCheckPreference()
	{
		return  this.duplicateCheckPreference;

	}

	/**
	 * The method to set the value to duplicateCheckPreference
	 * @param duplicateCheckPreference An instance of DuplicateCheckPreference
	 */
	public void setDuplicateCheckPreference(DuplicateCheckPreference duplicateCheckPreference)
	{
		 this.duplicateCheckPreference = duplicateCheckPreference;

		 this.keyModified.put("duplicate_check_preference", 1);

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