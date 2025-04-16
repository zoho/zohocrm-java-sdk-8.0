package com.zoho.crm.api.backup;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class History implements Model
{
	private Long id;

	private OffsetDateTime logTime;

	private String action;

	private String repeatType;

	private Integer count;

	private String fileName;

	private String state;

	private Requester doneBy;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of logTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getLogTime()
	{
		return  this.logTime;

	}

	/**
	 * The method to set the value to logTime
	 * @param logTime An instance of OffsetDateTime
	 */
	public void setLogTime(OffsetDateTime logTime)
	{
		 this.logTime = logTime;

		 this.keyModified.put("log_time", 1);

	}

	/**
	 * The method to get the value of action
	 * @return A String representing the action
	 */
	public String getAction()
	{
		return  this.action;

	}

	/**
	 * The method to set the value to action
	 * @param action A String representing the action
	 */
	public void setAction(String action)
	{
		 this.action = action;

		 this.keyModified.put("action", 1);

	}

	/**
	 * The method to get the value of repeatType
	 * @return A String representing the repeatType
	 */
	public String getRepeatType()
	{
		return  this.repeatType;

	}

	/**
	 * The method to set the value to repeatType
	 * @param repeatType A String representing the repeatType
	 */
	public void setRepeatType(String repeatType)
	{
		 this.repeatType = repeatType;

		 this.keyModified.put("repeat_type", 1);

	}

	/**
	 * The method to get the value of count
	 * @return An Integer representing the count
	 */
	public Integer getCount()
	{
		return  this.count;

	}

	/**
	 * The method to set the value to count
	 * @param count An Integer representing the count
	 */
	public void setCount(Integer count)
	{
		 this.count = count;

		 this.keyModified.put("count", 1);

	}

	/**
	 * The method to get the value of fileName
	 * @return A String representing the fileName
	 */
	public String getFileName()
	{
		return  this.fileName;

	}

	/**
	 * The method to set the value to fileName
	 * @param fileName A String representing the fileName
	 */
	public void setFileName(String fileName)
	{
		 this.fileName = fileName;

		 this.keyModified.put("file_name", 1);

	}

	/**
	 * The method to get the value of state
	 * @return A String representing the state
	 */
	public String getState()
	{
		return  this.state;

	}

	/**
	 * The method to set the value to state
	 * @param state A String representing the state
	 */
	public void setState(String state)
	{
		 this.state = state;

		 this.keyModified.put("state", 1);

	}

	/**
	 * The method to get the value of doneBy
	 * @return An instance of Requester
	 */
	public Requester getDoneBy()
	{
		return  this.doneBy;

	}

	/**
	 * The method to set the value to doneBy
	 * @param doneBy An instance of Requester
	 */
	public void setDoneBy(Requester doneBy)
	{
		 this.doneBy = doneBy;

		 this.keyModified.put("done_by", 1);

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