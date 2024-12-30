package com.zoho.crm.api.backup;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Backup implements Model
{
	private String rrule;

	private Long id;

	private OffsetDateTime startDate;

	private OffsetDateTime scheduledDate;

	private String status;

	private Requester requester;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of rrule
	 * @return A String representing the rrule
	 */
	public String getRrule()
	{
		return  this.rrule;

	}

	/**
	 * The method to set the value to rrule
	 * @param rrule A String representing the rrule
	 */
	public void setRrule(String rrule)
	{
		 this.rrule = rrule;

		 this.keyModified.put("rrule", 1);

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
	 * The method to get the value of startDate
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getStartDate()
	{
		return  this.startDate;

	}

	/**
	 * The method to set the value to startDate
	 * @param startDate An instance of OffsetDateTime
	 */
	public void setStartDate(OffsetDateTime startDate)
	{
		 this.startDate = startDate;

		 this.keyModified.put("start_date", 1);

	}

	/**
	 * The method to get the value of scheduledDate
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getScheduledDate()
	{
		return  this.scheduledDate;

	}

	/**
	 * The method to set the value to scheduledDate
	 * @param scheduledDate An instance of OffsetDateTime
	 */
	public void setScheduledDate(OffsetDateTime scheduledDate)
	{
		 this.scheduledDate = scheduledDate;

		 this.keyModified.put("scheduled_date", 1);

	}

	/**
	 * The method to get the value of status
	 * @return A String representing the status
	 */
	public String getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status A String representing the status
	 */
	public void setStatus(String status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

	}

	/**
	 * The method to get the value of requester
	 * @return An instance of Requester
	 */
	public Requester getRequester()
	{
		return  this.requester;

	}

	/**
	 * The method to set the value to requester
	 * @param requester An instance of Requester
	 */
	public void setRequester(Requester requester)
	{
		 this.requester = requester;

		 this.keyModified.put("requester", 1);

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