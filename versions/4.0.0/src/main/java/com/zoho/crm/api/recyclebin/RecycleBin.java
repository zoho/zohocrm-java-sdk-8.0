package com.zoho.crm.api.recyclebin;

import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class RecycleBin implements Model
{
	private String displayName;

	private OffsetDateTime deletedTime;

	private MinifiedUser owner;

	private MinifiedModule module;

	private MinifiedUser deletedBy;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of displayName
	 * @return A String representing the displayName
	 */
	public String getDisplayName()
	{
		return  this.displayName;

	}

	/**
	 * The method to set the value to displayName
	 * @param displayName A String representing the displayName
	 */
	public void setDisplayName(String displayName)
	{
		 this.displayName = displayName;

		 this.keyModified.put("display_name", 1);

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
	 * The method to get the value of owner
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getOwner()
	{
		return  this.owner;

	}

	/**
	 * The method to set the value to owner
	 * @param owner An instance of MinifiedUser
	 */
	public void setOwner(MinifiedUser owner)
	{
		 this.owner = owner;

		 this.keyModified.put("owner", 1);

	}

	/**
	 * The method to get the value of module
	 * @return An instance of MinifiedModule
	 */
	public MinifiedModule getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of MinifiedModule
	 */
	public void setModule(MinifiedModule module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

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
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

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