package com.zoho.crm.api.unblockemail;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<String> ids;

	private List<String> unblockFields;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of unblockFields
	 * @return An instance of List<String>
	 */
	public List<String> getUnblockFields()
	{
		return  this.unblockFields;

	}

	/**
	 * The method to set the value to unblockFields
	 * @param unblockFields An instance of List<String>
	 */
	public void setUnblockFields(List<String> unblockFields)
	{
		 this.unblockFields = unblockFields;

		 this.keyModified.put("unblock_fields", 1);

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