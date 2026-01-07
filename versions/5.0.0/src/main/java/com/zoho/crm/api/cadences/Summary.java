package com.zoho.crm.api.cadences;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Summary implements Model
{
	private Integer taskFollowUpCount;

	private Integer callFollowUpCount;

	private Integer emailFollowUpCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of taskFollowUpCount
	 * @return An Integer representing the taskFollowUpCount
	 */
	public Integer getTaskFollowUpCount()
	{
		return  this.taskFollowUpCount;

	}

	/**
	 * The method to set the value to taskFollowUpCount
	 * @param taskFollowUpCount An Integer representing the taskFollowUpCount
	 */
	public void setTaskFollowUpCount(Integer taskFollowUpCount)
	{
		 this.taskFollowUpCount = taskFollowUpCount;

		 this.keyModified.put("task_follow_up_count", 1);

	}

	/**
	 * The method to get the value of callFollowUpCount
	 * @return An Integer representing the callFollowUpCount
	 */
	public Integer getCallFollowUpCount()
	{
		return  this.callFollowUpCount;

	}

	/**
	 * The method to set the value to callFollowUpCount
	 * @param callFollowUpCount An Integer representing the callFollowUpCount
	 */
	public void setCallFollowUpCount(Integer callFollowUpCount)
	{
		 this.callFollowUpCount = callFollowUpCount;

		 this.keyModified.put("call_follow_up_count", 1);

	}

	/**
	 * The method to get the value of emailFollowUpCount
	 * @return An Integer representing the emailFollowUpCount
	 */
	public Integer getEmailFollowUpCount()
	{
		return  this.emailFollowUpCount;

	}

	/**
	 * The method to set the value to emailFollowUpCount
	 * @param emailFollowUpCount An Integer representing the emailFollowUpCount
	 */
	public void setEmailFollowUpCount(Integer emailFollowUpCount)
	{
		 this.emailFollowUpCount = emailFollowUpCount;

		 this.keyModified.put("email_follow_up_count", 1);

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