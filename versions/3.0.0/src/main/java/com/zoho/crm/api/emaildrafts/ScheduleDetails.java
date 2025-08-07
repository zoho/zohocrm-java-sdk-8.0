package com.zoho.crm.api.emaildrafts;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.TimeZone;

public class ScheduleDetails implements Model
{
	private OffsetDateTime time;

	private TimeZone timezone;

	private String source;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of time
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getTime()
	{
		return  this.time;

	}

	/**
	 * The method to set the value to time
	 * @param time An instance of OffsetDateTime
	 */
	public void setTime(OffsetDateTime time)
	{
		 this.time = time;

		 this.keyModified.put("time", 1);

	}

	/**
	 * The method to get the value of timezone
	 * @return An instance of TimeZone
	 */
	public TimeZone getTimezone()
	{
		return  this.timezone;

	}

	/**
	 * The method to set the value to timezone
	 * @param timezone An instance of TimeZone
	 */
	public void setTimezone(TimeZone timezone)
	{
		 this.timezone = timezone;

		 this.keyModified.put("timezone", 1);

	}

	/**
	 * The method to get the value of source
	 * @return A String representing the source
	 */
	public String getSource()
	{
		return  this.source;

	}

	/**
	 * The method to set the value to source
	 * @param source A String representing the source
	 */
	public void setSource(String source)
	{
		 this.source = source;

		 this.keyModified.put("source", 1);

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