package com.zoho.crm.api.fiscalyear;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Year implements Model
{
	private Choice<String> startMonth;

	private Choice<String> displayBasedOn;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of startMonth
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getStartMonth()
	{
		return  this.startMonth;

	}

	/**
	 * The method to set the value to startMonth
	 * @param startMonth An instance of Choice<String>
	 */
	public void setStartMonth(Choice<String> startMonth)
	{
		 this.startMonth = startMonth;

		 this.keyModified.put("start_month", 1);

	}

	/**
	 * The method to get the value of displayBasedOn
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getDisplayBasedOn()
	{
		return  this.displayBasedOn;

	}

	/**
	 * The method to set the value to displayBasedOn
	 * @param displayBasedOn An instance of Choice<String>
	 */
	public void setDisplayBasedOn(Choice<String> displayBasedOn)
	{
		 this.displayBasedOn = displayBasedOn;

		 this.keyModified.put("display_based_on", 1);

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