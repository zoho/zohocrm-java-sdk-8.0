package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AssociatedUser implements Model
{
	private UserGroup userGroup;

	private Integer count;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of userGroup
	 * @return An instance of UserGroup
	 */
	public UserGroup getUserGroup()
	{
		return  this.userGroup;

	}

	/**
	 * The method to set the value to userGroup
	 * @param userGroup An instance of UserGroup
	 */
	public void setUserGroup(UserGroup userGroup)
	{
		 this.userGroup = userGroup;

		 this.keyModified.put("user_group", 1);

	}

	/**
	 * The method to get the value of count
	 * @return An Integer representing the count
	 */
	public Integer getCount()
	{
		return  this.count;

	}

	/**
	 * The method to set the value to count
	 * @param count An Integer representing the count
	 */
	public void setCount(Integer count)
	{
		 this.count = count;

		 this.keyModified.put("count", 1);

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