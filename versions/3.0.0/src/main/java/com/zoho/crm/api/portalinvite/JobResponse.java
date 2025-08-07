package com.zoho.crm.api.portalinvite;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class JobResponse implements Model
{
	private List<Data> data;

	private Long jobId;

	private String status;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of data
	 * @return An instance of List<Data>
	 */
	public List<Data> getData()
	{
		return  this.data;

	}

	/**
	 * The method to set the value to data
	 * @param data An instance of List<Data>
	 */
	public void setData(List<Data> data)
	{
		 this.data = data;

		 this.keyModified.put("data", 1);

	}

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