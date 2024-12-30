package com.zoho.crm.api.cadencesexecution;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AnalyticsTask implements Model
{
	private Integer openTasksCount;

	private Integer failedTasksCount;

	private String subject;

	private Integer completedTasksCount;

	private Integer createdTasksCount;

	private Integer tasksCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of openTasksCount
	 * @return An Integer representing the openTasksCount
	 */
	public Integer getOpenTasksCount()
	{
		return  this.openTasksCount;

	}

	/**
	 * The method to set the value to openTasksCount
	 * @param openTasksCount An Integer representing the openTasksCount
	 */
	public void setOpenTasksCount(Integer openTasksCount)
	{
		 this.openTasksCount = openTasksCount;

		 this.keyModified.put("open_tasks_count", 1);

	}

	/**
	 * The method to get the value of failedTasksCount
	 * @return An Integer representing the failedTasksCount
	 */
	public Integer getFailedTasksCount()
	{
		return  this.failedTasksCount;

	}

	/**
	 * The method to set the value to failedTasksCount
	 * @param failedTasksCount An Integer representing the failedTasksCount
	 */
	public void setFailedTasksCount(Integer failedTasksCount)
	{
		 this.failedTasksCount = failedTasksCount;

		 this.keyModified.put("failed_tasks_count", 1);

	}

	/**
	 * The method to get the value of subject
	 * @return A String representing the subject
	 */
	public String getSubject()
	{
		return  this.subject;

	}

	/**
	 * The method to set the value to subject
	 * @param subject A String representing the subject
	 */
	public void setSubject(String subject)
	{
		 this.subject = subject;

		 this.keyModified.put("subject", 1);

	}

	/**
	 * The method to get the value of completedTasksCount
	 * @return An Integer representing the completedTasksCount
	 */
	public Integer getCompletedTasksCount()
	{
		return  this.completedTasksCount;

	}

	/**
	 * The method to set the value to completedTasksCount
	 * @param completedTasksCount An Integer representing the completedTasksCount
	 */
	public void setCompletedTasksCount(Integer completedTasksCount)
	{
		 this.completedTasksCount = completedTasksCount;

		 this.keyModified.put("completed_tasks_count", 1);

	}

	/**
	 * The method to get the value of createdTasksCount
	 * @return An Integer representing the createdTasksCount
	 */
	public Integer getCreatedTasksCount()
	{
		return  this.createdTasksCount;

	}

	/**
	 * The method to set the value to createdTasksCount
	 * @param createdTasksCount An Integer representing the createdTasksCount
	 */
	public void setCreatedTasksCount(Integer createdTasksCount)
	{
		 this.createdTasksCount = createdTasksCount;

		 this.keyModified.put("created_tasks_count", 1);

	}

	/**
	 * The method to get the value of tasksCount
	 * @return An Integer representing the tasksCount
	 */
	public Integer getTasksCount()
	{
		return  this.tasksCount;

	}

	/**
	 * The method to set the value to tasksCount
	 * @param tasksCount An Integer representing the tasksCount
	 */
	public void setTasksCount(Integer tasksCount)
	{
		 this.tasksCount = tasksCount;

		 this.keyModified.put("tasks_count", 1);

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