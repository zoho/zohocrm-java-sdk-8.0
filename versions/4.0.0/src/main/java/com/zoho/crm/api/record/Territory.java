package com.zoho.crm.api.record;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Territory implements Model
{
	private String assigned;

	private String name;

	private Long id;

	private OffsetDateTime assignedTime;

	private MinifiedUser assignedBy;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of assigned
	 * @return A String representing the assigned
	 */
	public String getAssigned()
	{
		return  this.assigned;

	}

	/**
	 * The method to set the value to assigned
	 * @param assigned A String representing the assigned
	 */
	public void setAssigned(String assigned)
	{
		 this.assigned = assigned;

		 this.keyModified.put("$assigned", 1);

	}

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

		 this.keyModified.put("Name", 1);

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
	 * The method to get the value of assignedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getAssignedTime()
	{
		return  this.assignedTime;

	}

	/**
	 * The method to set the value to assignedTime
	 * @param assignedTime An instance of OffsetDateTime
	 */
	public void setAssignedTime(OffsetDateTime assignedTime)
	{
		 this.assignedTime = assignedTime;

		 this.keyModified.put("$assigned_time", 1);

	}

	/**
	 * The method to get the value of assignedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getAssignedBy()
	{
		return  this.assignedBy;

	}

	/**
	 * The method to set the value to assignedBy
	 * @param assignedBy An instance of MinifiedUser
	 */
	public void setAssignedBy(MinifiedUser assignedBy)
	{
		 this.assignedBy = assignedBy;

		 this.keyModified.put("$assigned_by", 1);

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