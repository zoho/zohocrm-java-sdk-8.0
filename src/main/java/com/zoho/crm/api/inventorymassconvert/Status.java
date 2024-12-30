package com.zoho.crm.api.inventorymassconvert;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Status implements Model, ResponseHandler
{
	private Integer totalCount;

	private Integer convertedCount;

	private Integer notConvertedCount;

	private Integer failedCount;

	private String status;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of totalCount
	 * @return An Integer representing the totalCount
	 */
	public Integer getTotalCount()
	{
		return  this.totalCount;

	}

	/**
	 * The method to set the value to totalCount
	 * @param totalCount An Integer representing the totalCount
	 */
	public void setTotalCount(Integer totalCount)
	{
		 this.totalCount = totalCount;

		 this.keyModified.put("total_count", 1);

	}

	/**
	 * The method to get the value of convertedCount
	 * @return An Integer representing the convertedCount
	 */
	public Integer getConvertedCount()
	{
		return  this.convertedCount;

	}

	/**
	 * The method to set the value to convertedCount
	 * @param convertedCount An Integer representing the convertedCount
	 */
	public void setConvertedCount(Integer convertedCount)
	{
		 this.convertedCount = convertedCount;

		 this.keyModified.put("converted_count", 1);

	}

	/**
	 * The method to get the value of notConvertedCount
	 * @return An Integer representing the notConvertedCount
	 */
	public Integer getNotConvertedCount()
	{
		return  this.notConvertedCount;

	}

	/**
	 * The method to set the value to notConvertedCount
	 * @param notConvertedCount An Integer representing the notConvertedCount
	 */
	public void setNotConvertedCount(Integer notConvertedCount)
	{
		 this.notConvertedCount = notConvertedCount;

		 this.keyModified.put("not_converted_count", 1);

	}

	/**
	 * The method to get the value of failedCount
	 * @return An Integer representing the failedCount
	 */
	public Integer getFailedCount()
	{
		return  this.failedCount;

	}

	/**
	 * The method to set the value to failedCount
	 * @param failedCount An Integer representing the failedCount
	 */
	public void setFailedCount(Integer failedCount)
	{
		 this.failedCount = failedCount;

		 this.keyModified.put("failed_count", 1);

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