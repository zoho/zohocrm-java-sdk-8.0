package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ZiaPeopleEnrichment implements Model
{
	private String createdTime;

	private Long id;

	private User createdBy;

	private String status;

	private EnrichedData enrichedData;

	private EnrichBasedOn enrichBasedOn;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of createdTime
	 * @return A String representing the createdTime
	 */
	public String getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime A String representing the createdTime
	 */
	public void setCreatedTime(String createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

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
	 * The method to get the value of createdBy
	 * @return An instance of User
	 */
	public User getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of User
	 */
	public void setCreatedBy(User createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

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
	 * The method to get the value of enrichedData
	 * @return An instance of EnrichedData
	 */
	public EnrichedData getEnrichedData()
	{
		return  this.enrichedData;

	}

	/**
	 * The method to set the value to enrichedData
	 * @param enrichedData An instance of EnrichedData
	 */
	public void setEnrichedData(EnrichedData enrichedData)
	{
		 this.enrichedData = enrichedData;

		 this.keyModified.put("enriched_data", 1);

	}

	/**
	 * The method to get the value of enrichBasedOn
	 * @return An instance of EnrichBasedOn
	 */
	public EnrichBasedOn getEnrichBasedOn()
	{
		return  this.enrichBasedOn;

	}

	/**
	 * The method to set the value to enrichBasedOn
	 * @param enrichBasedOn An instance of EnrichBasedOn
	 */
	public void setEnrichBasedOn(EnrichBasedOn enrichBasedOn)
	{
		 this.enrichBasedOn = enrichBasedOn;

		 this.keyModified.put("enrich_based_on", 1);

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