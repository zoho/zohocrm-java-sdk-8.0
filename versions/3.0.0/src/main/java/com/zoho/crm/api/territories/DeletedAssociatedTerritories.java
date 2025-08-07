package com.zoho.crm.api.territories;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class DeletedAssociatedTerritories implements Model
{
	private String name;

	private String id;

	private OffsetDateTime deletedTime;

	private MinifiedUser deletedBy;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of deletedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getDeletedTime()
	{
		return  this.deletedTime;

	}

	/**
	 * The method to set the value to deletedTime
	 * @param deletedTime An instance of OffsetDateTime
	 */
	public void setDeletedTime(OffsetDateTime deletedTime)
	{
		 this.deletedTime = deletedTime;

		 this.keyModified.put("deleted_time", 1);

	}

	/**
	 * The method to get the value of deletedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getDeletedBy()
	{
		return  this.deletedBy;

	}

	/**
	 * The method to set the value to deletedBy
	 * @param deletedBy An instance of MinifiedUser
	 */
	public void setDeletedBy(MinifiedUser deletedBy)
	{
		 this.deletedBy = deletedBy;

		 this.keyModified.put("deleted_by", 1);

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