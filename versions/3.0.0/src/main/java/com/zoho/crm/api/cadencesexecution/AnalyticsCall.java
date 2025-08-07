package com.zoho.crm.api.cadencesexecution;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AnalyticsCall implements Model
{
	private Integer createdCallsCount;

	private Integer cancelledCallsCount;

	private Integer failedCallsCount;

	private Integer completedCallsCount;

	private Integer scheduledCallsCount;

	private Integer callsCount;

	private Integer overdueCallsCount;

	private Integer missedCallsCount;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of createdCallsCount
	 * @return An Integer representing the createdCallsCount
	 */
	public Integer getCreatedCallsCount()
	{
		return  this.createdCallsCount;

	}

	/**
	 * The method to set the value to createdCallsCount
	 * @param createdCallsCount An Integer representing the createdCallsCount
	 */
	public void setCreatedCallsCount(Integer createdCallsCount)
	{
		 this.createdCallsCount = createdCallsCount;

		 this.keyModified.put("created_calls_count", 1);

	}

	/**
	 * The method to get the value of cancelledCallsCount
	 * @return An Integer representing the cancelledCallsCount
	 */
	public Integer getCancelledCallsCount()
	{
		return  this.cancelledCallsCount;

	}

	/**
	 * The method to set the value to cancelledCallsCount
	 * @param cancelledCallsCount An Integer representing the cancelledCallsCount
	 */
	public void setCancelledCallsCount(Integer cancelledCallsCount)
	{
		 this.cancelledCallsCount = cancelledCallsCount;

		 this.keyModified.put("cancelled_calls_count", 1);

	}

	/**
	 * The method to get the value of failedCallsCount
	 * @return An Integer representing the failedCallsCount
	 */
	public Integer getFailedCallsCount()
	{
		return  this.failedCallsCount;

	}

	/**
	 * The method to set the value to failedCallsCount
	 * @param failedCallsCount An Integer representing the failedCallsCount
	 */
	public void setFailedCallsCount(Integer failedCallsCount)
	{
		 this.failedCallsCount = failedCallsCount;

		 this.keyModified.put("failed_calls_count", 1);

	}

	/**
	 * The method to get the value of completedCallsCount
	 * @return An Integer representing the completedCallsCount
	 */
	public Integer getCompletedCallsCount()
	{
		return  this.completedCallsCount;

	}

	/**
	 * The method to set the value to completedCallsCount
	 * @param completedCallsCount An Integer representing the completedCallsCount
	 */
	public void setCompletedCallsCount(Integer completedCallsCount)
	{
		 this.completedCallsCount = completedCallsCount;

		 this.keyModified.put("completed_calls_count", 1);

	}

	/**
	 * The method to get the value of scheduledCallsCount
	 * @return An Integer representing the scheduledCallsCount
	 */
	public Integer getScheduledCallsCount()
	{
		return  this.scheduledCallsCount;

	}

	/**
	 * The method to set the value to scheduledCallsCount
	 * @param scheduledCallsCount An Integer representing the scheduledCallsCount
	 */
	public void setScheduledCallsCount(Integer scheduledCallsCount)
	{
		 this.scheduledCallsCount = scheduledCallsCount;

		 this.keyModified.put("scheduled_calls_count", 1);

	}

	/**
	 * The method to get the value of callsCount
	 * @return An Integer representing the callsCount
	 */
	public Integer getCallsCount()
	{
		return  this.callsCount;

	}

	/**
	 * The method to set the value to callsCount
	 * @param callsCount An Integer representing the callsCount
	 */
	public void setCallsCount(Integer callsCount)
	{
		 this.callsCount = callsCount;

		 this.keyModified.put("calls_count", 1);

	}

	/**
	 * The method to get the value of overdueCallsCount
	 * @return An Integer representing the overdueCallsCount
	 */
	public Integer getOverdueCallsCount()
	{
		return  this.overdueCallsCount;

	}

	/**
	 * The method to set the value to overdueCallsCount
	 * @param overdueCallsCount An Integer representing the overdueCallsCount
	 */
	public void setOverdueCallsCount(Integer overdueCallsCount)
	{
		 this.overdueCallsCount = overdueCallsCount;

		 this.keyModified.put("overdue_calls_count", 1);

	}

	/**
	 * The method to get the value of missedCallsCount
	 * @return An Integer representing the missedCallsCount
	 */
	public Integer getMissedCallsCount()
	{
		return  this.missedCallsCount;

	}

	/**
	 * The method to set the value to missedCallsCount
	 * @param missedCallsCount An Integer representing the missedCallsCount
	 */
	public void setMissedCallsCount(Integer missedCallsCount)
	{
		 this.missedCallsCount = missedCallsCount;

		 this.keyModified.put("missed_calls_count", 1);

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