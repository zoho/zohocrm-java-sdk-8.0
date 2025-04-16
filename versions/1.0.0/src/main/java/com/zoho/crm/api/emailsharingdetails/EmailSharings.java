package com.zoho.crm.api.emailsharingdetails;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class EmailSharings implements Model
{
	private List<ShareFromUser> shareFromUsers;

	private List<String> availableTypes;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of shareFromUsers
	 * @return An instance of List<ShareFromUser>
	 */
	public List<ShareFromUser> getShareFromUsers()
	{
		return  this.shareFromUsers;

	}

	/**
	 * The method to set the value to shareFromUsers
	 * @param shareFromUsers An instance of List<ShareFromUser>
	 */
	public void setShareFromUsers(List<ShareFromUser> shareFromUsers)
	{
		 this.shareFromUsers = shareFromUsers;

		 this.keyModified.put("share_from_users", 1);

	}

	/**
	 * The method to get the value of availableTypes
	 * @return An instance of List<String>
	 */
	public List<String> getAvailableTypes()
	{
		return  this.availableTypes;

	}

	/**
	 * The method to set the value to availableTypes
	 * @param availableTypes An instance of List<String>
	 */
	public void setAvailableTypes(List<String> availableTypes)
	{
		 this.availableTypes = availableTypes;

		 this.keyModified.put("available_types", 1);

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