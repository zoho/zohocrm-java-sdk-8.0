package com.zoho.crm.api.shifthours;

import com.zoho.crm.api.util.Model;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class BreakHours implements Model
{
	private List<String> breakDays;

	private Boolean sameAsEveryday;

	private List<LocalTime> dailyTiming;

	private List<BreakCustomTiming> customTiming;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of breakDays
	 * @return An instance of List<String>
	 */
	public List<String> getBreakDays()
	{
		return  this.breakDays;

	}

	/**
	 * The method to set the value to breakDays
	 * @param breakDays An instance of List<String>
	 */
	public void setBreakDays(List<String> breakDays)
	{
		 this.breakDays = breakDays;

		 this.keyModified.put("break_days", 1);

	}

	/**
	 * The method to get the value of sameAsEveryday
	 * @return A Boolean representing the sameAsEveryday
	 */
	public Boolean getSameAsEveryday()
	{
		return  this.sameAsEveryday;

	}

	/**
	 * The method to set the value to sameAsEveryday
	 * @param sameAsEveryday A Boolean representing the sameAsEveryday
	 */
	public void setSameAsEveryday(Boolean sameAsEveryday)
	{
		 this.sameAsEveryday = sameAsEveryday;

		 this.keyModified.put("same_as_everyday", 1);

	}

	/**
	 * The method to get the value of dailyTiming
	 * @return An instance of List<LocalTime>
	 */
	public List<LocalTime> getDailyTiming()
	{
		return  this.dailyTiming;

	}

	/**
	 * The method to set the value to dailyTiming
	 * @param dailyTiming An instance of List<LocalTime>
	 */
	public void setDailyTiming(List<LocalTime> dailyTiming)
	{
		 this.dailyTiming = dailyTiming;

		 this.keyModified.put("daily_timing", 1);

	}

	/**
	 * The method to get the value of customTiming
	 * @return An instance of List<BreakCustomTiming>
	 */
	public List<BreakCustomTiming> getCustomTiming()
	{
		return  this.customTiming;

	}

	/**
	 * The method to set the value to customTiming
	 * @param customTiming An instance of List<BreakCustomTiming>
	 */
	public void setCustomTiming(List<BreakCustomTiming> customTiming)
	{
		 this.customTiming = customTiming;

		 this.keyModified.put("custom_timing", 1);

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