package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Users implements Model
{
	private Integer inactive;

	private Integer deleted;

	private Integer active;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of inactive
	 * @return An Integer representing the inactive
	 */
	public Integer getInactive()
	{
		return  this.inactive;

	}

	/**
	 * The method to set the value to inactive
	 * @param inactive An Integer representing the inactive
	 */
	public void setInactive(Integer inactive)
	{
		 this.inactive = inactive;

		 this.keyModified.put("inactive", 1);

	}

	/**
	 * The method to get the value of deleted
	 * @return An Integer representing the deleted
	 */
	public Integer getDeleted()
	{
		return  this.deleted;

	}

	/**
	 * The method to set the value to deleted
	 * @param deleted An Integer representing the deleted
	 */
	public void setDeleted(Integer deleted)
	{
		 this.deleted = deleted;

		 this.keyModified.put("deleted", 1);

	}

	/**
	 * The method to get the value of active
	 * @return An Integer representing the active
	 */
	public Integer getActive()
	{
		return  this.active;

	}

	/**
	 * The method to set the value to active
	 * @param active An Integer representing the active
	 */
	public void setActive(Integer active)
	{
		 this.active = active;

		 this.keyModified.put("active", 1);

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