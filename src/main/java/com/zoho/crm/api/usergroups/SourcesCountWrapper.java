package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class SourcesCountWrapper implements Model, ResponseHandler
{
	private List<SourcesCount> sourcesCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of sourcesCount
	 * @return An instance of List<SourcesCount>
	 */
	public List<SourcesCount> getSourcesCount()
	{
		return  this.sourcesCount;

	}

	/**
	 * The method to set the value to sourcesCount
	 * @param sourcesCount An instance of List<SourcesCount>
	 */
	public void setSourcesCount(List<SourcesCount> sourcesCount)
	{
		 this.sourcesCount = sourcesCount;

		 this.keyModified.put("sources_count", 1);

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