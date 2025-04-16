package com.zoho.crm.api.cadencesexecution;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<String> cadencesIds;

	private List<String> ids;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of cadencesIds
	 * @return An instance of List<String>
	 */
	public List<String> getCadencesIds()
	{
		return  this.cadencesIds;

	}

	/**
	 * The method to set the value to cadencesIds
	 * @param cadencesIds An instance of List<String>
	 */
	public void setCadencesIds(List<String> cadencesIds)
	{
		 this.cadencesIds = cadencesIds;

		 this.keyModified.put("cadences_ids", 1);

	}

	/**
	 * The method to get the value of ids
	 * @return An instance of List<String>
	 */
	public List<String> getIds()
	{
		return  this.ids;

	}

	/**
	 * The method to set the value to ids
	 * @param ids An instance of List<String>
	 */
	public void setIds(List<String> ids)
	{
		 this.ids = ids;

		 this.keyModified.put("ids", 1);

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