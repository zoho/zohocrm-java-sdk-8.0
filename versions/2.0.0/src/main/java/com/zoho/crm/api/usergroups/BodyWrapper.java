package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<Groups> userGroups;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of userGroups
	 * @return An instance of List<Groups>
	 */
	public List<Groups> getUserGroups()
	{
		return  this.userGroups;

	}

	/**
	 * The method to set the value to userGroups
	 * @param userGroups An instance of List<Groups>
	 */
	public void setUserGroups(List<Groups> userGroups)
	{
		 this.userGroups = userGroups;

		 this.keyModified.put("user_groups", 1);

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