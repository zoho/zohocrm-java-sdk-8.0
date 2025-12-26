package com.zoho.crm.api.globalpicklists;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ReplaceActionWrapper implements Model, ReplaceActionHandler
{
	private List<ReplaceActionResponse> replacePicklistValues;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of replacePicklistValues
	 * @return An instance of List<ReplaceActionResponse>
	 */
	public List<ReplaceActionResponse> getReplacePicklistValues()
	{
		return  this.replacePicklistValues;

	}

	/**
	 * The method to set the value to replacePicklistValues
	 * @param replacePicklistValues An instance of List<ReplaceActionResponse>
	 */
	public void setReplacePicklistValues(List<ReplaceActionResponse> replacePicklistValues)
	{
		 this.replacePicklistValues = replacePicklistValues;

		 this.keyModified.put("replace_picklist_values", 1);

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