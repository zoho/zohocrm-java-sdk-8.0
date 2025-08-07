package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Experience implements Model
{
	private String endDate;

	private String companyName;

	private String title;

	private String startDate;

	private Boolean primary;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of endDate
	 * @return A String representing the endDate
	 */
	public String getEndDate()
	{
		return  this.endDate;

	}

	/**
	 * The method to set the value to endDate
	 * @param endDate A String representing the endDate
	 */
	public void setEndDate(String endDate)
	{
		 this.endDate = endDate;

		 this.keyModified.put("end_date", 1);

	}

	/**
	 * The method to get the value of companyName
	 * @return A String representing the companyName
	 */
	public String getCompanyName()
	{
		return  this.companyName;

	}

	/**
	 * The method to set the value to companyName
	 * @param companyName A String representing the companyName
	 */
	public void setCompanyName(String companyName)
	{
		 this.companyName = companyName;

		 this.keyModified.put("company_name", 1);

	}

	/**
	 * The method to get the value of title
	 * @return A String representing the title
	 */
	public String getTitle()
	{
		return  this.title;

	}

	/**
	 * The method to set the value to title
	 * @param title A String representing the title
	 */
	public void setTitle(String title)
	{
		 this.title = title;

		 this.keyModified.put("title", 1);

	}

	/**
	 * The method to get the value of startDate
	 * @return A String representing the startDate
	 */
	public String getStartDate()
	{
		return  this.startDate;

	}

	/**
	 * The method to set the value to startDate
	 * @param startDate A String representing the startDate
	 */
	public void setStartDate(String startDate)
	{
		 this.startDate = startDate;

		 this.keyModified.put("start_date", 1);

	}

	/**
	 * The method to get the value of primary
	 * @return A Boolean representing the primary
	 */
	public Boolean getPrimary()
	{
		return  this.primary;

	}

	/**
	 * The method to set the value to primary
	 * @param primary A Boolean representing the primary
	 */
	public void setPrimary(Boolean primary)
	{
		 this.primary = primary;

		 this.keyModified.put("primary", 1);

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