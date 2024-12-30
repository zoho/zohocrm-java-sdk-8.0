package com.zoho.crm.api.massdeletetags;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class MassDeleteDetails implements Model, StatusActionResponse
{
	private Long jobId;

	private Integer totalCount;

	private Integer failedCount;

	private Integer deletedCount;

	private Choice<String> status;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of jobId
	 * @return A Long representing the jobId
	 */
	public Long getJobId()
	{
		return  this.jobId;

	}

	/**
	 * The method to set the value to jobId
	 * @param jobId A Long representing the jobId
	 */
	public void setJobId(Long jobId)
	{
		 this.jobId = jobId;

		 this.keyModified.put("job_id", 1);

	}

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
	 * The method to get the value of deletedCount
	 * @return An Integer representing the deletedCount
	 */
	public Integer getDeletedCount()
	{
		return  this.deletedCount;

	}

	/**
	 * The method to set the value to deletedCount
	 * @param deletedCount An Integer representing the deletedCount
	 */
	public void setDeletedCount(Integer deletedCount)
	{
		 this.deletedCount = deletedCount;

		 this.keyModified.put("deleted_count", 1);

	}

	/**
	 * The method to get the value of status
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status An instance of Choice<String>
	 */
	public void setStatus(Choice<String> status)
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