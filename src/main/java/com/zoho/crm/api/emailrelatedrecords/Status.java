package com.zoho.crm.api.emailrelatedrecords;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Status implements Model
{
	private OffsetDateTime firstOpen;

	private String count;

	private String type;

	private OffsetDateTime lastOpen;

	private OffsetDateTime bouncedTime;

	private String bouncedReason;

	private String category;

	private String subCategory;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of firstOpen
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getFirstOpen()
	{
		return  this.firstOpen;

	}

	/**
	 * The method to set the value to firstOpen
	 * @param firstOpen An instance of OffsetDateTime
	 */
	public void setFirstOpen(OffsetDateTime firstOpen)
	{
		 this.firstOpen = firstOpen;

		 this.keyModified.put("first_open", 1);

	}

	/**
	 * The method to get the value of count
	 * @return A String representing the count
	 */
	public String getCount()
	{
		return  this.count;

	}

	/**
	 * The method to set the value to count
	 * @param count A String representing the count
	 */
	public void setCount(String count)
	{
		 this.count = count;

		 this.keyModified.put("count", 1);

	}

	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of lastOpen
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getLastOpen()
	{
		return  this.lastOpen;

	}

	/**
	 * The method to set the value to lastOpen
	 * @param lastOpen An instance of OffsetDateTime
	 */
	public void setLastOpen(OffsetDateTime lastOpen)
	{
		 this.lastOpen = lastOpen;

		 this.keyModified.put("last_open", 1);

	}

	/**
	 * The method to get the value of bouncedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getBouncedTime()
	{
		return  this.bouncedTime;

	}

	/**
	 * The method to set the value to bouncedTime
	 * @param bouncedTime An instance of OffsetDateTime
	 */
	public void setBouncedTime(OffsetDateTime bouncedTime)
	{
		 this.bouncedTime = bouncedTime;

		 this.keyModified.put("bounced_time", 1);

	}

	/**
	 * The method to get the value of bouncedReason
	 * @return A String representing the bouncedReason
	 */
	public String getBouncedReason()
	{
		return  this.bouncedReason;

	}

	/**
	 * The method to set the value to bouncedReason
	 * @param bouncedReason A String representing the bouncedReason
	 */
	public void setBouncedReason(String bouncedReason)
	{
		 this.bouncedReason = bouncedReason;

		 this.keyModified.put("bounced_reason", 1);

	}

	/**
	 * The method to get the value of category
	 * @return A String representing the category
	 */
	public String getCategory()
	{
		return  this.category;

	}

	/**
	 * The method to set the value to category
	 * @param category A String representing the category
	 */
	public void setCategory(String category)
	{
		 this.category = category;

		 this.keyModified.put("category", 1);

	}

	/**
	 * The method to get the value of subCategory
	 * @return A String representing the subCategory
	 */
	public String getSubCategory()
	{
		return  this.subCategory;

	}

	/**
	 * The method to set the value to subCategory
	 * @param subCategory A String representing the subCategory
	 */
	public void setSubCategory(String subCategory)
	{
		 this.subCategory = subCategory;

		 this.keyModified.put("sub_category", 1);

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