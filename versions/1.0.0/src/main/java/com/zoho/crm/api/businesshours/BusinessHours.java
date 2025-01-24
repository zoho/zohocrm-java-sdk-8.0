package com.zoho.crm.api.businesshours;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BusinessHours implements Model
{
	private Choice<String> weekStartsOn;

	private Choice<String> type;

	private Long id;

	private List<Choice<String>> businessDays;

	private Boolean sameAsEveryday;

	private List<String> dailyTiming;

	private List<BreakHoursCustomTiming> customTiming;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of weekStartsOn
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getWeekStartsOn()
	{
		return  this.weekStartsOn;

	}

	/**
	 * The method to set the value to weekStartsOn
	 * @param weekStartsOn An instance of Choice<String>
	 */
	public void setWeekStartsOn(Choice<String> weekStartsOn)
	{
		 this.weekStartsOn = weekStartsOn;

		 this.keyModified.put("week_starts_on", 1);

	}

	/**
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

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
	 * The method to get the value of businessDays
	 * @return An instance of List<Choice>
	 */
	public List<Choice<String>> getBusinessDays()
	{
		return  this.businessDays;

	}

	/**
	 * The method to set the value to businessDays
	 * @param businessDays An instance of List<Choice>
	 */
	public void setBusinessDays(List<Choice<String>> businessDays)
	{
		 this.businessDays = businessDays;

		 this.keyModified.put("business_days", 1);

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
	 * @return An instance of List<String>
	 */
	public List<String> getDailyTiming()
	{
		return  this.dailyTiming;

	}

	/**
	 * The method to set the value to dailyTiming
	 * @param dailyTiming An instance of List<String>
	 */
	public void setDailyTiming(List<String> dailyTiming)
	{
		 this.dailyTiming = dailyTiming;

		 this.keyModified.put("daily_timing", 1);

	}

	/**
	 * The method to get the value of customTiming
	 * @return An instance of List<BreakHoursCustomTiming>
	 */
	public List<BreakHoursCustomTiming> getCustomTiming()
	{
		return  this.customTiming;

	}

	/**
	 * The method to set the value to customTiming
	 * @param customTiming An instance of List<BreakHoursCustomTiming>
	 */
	public void setCustomTiming(List<BreakHoursCustomTiming> customTiming)
	{
		 this.customTiming = customTiming;

		 this.keyModified.put("custom_timing", 1);

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