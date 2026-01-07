package com.zoho.crm.api.cadences;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ExecutionDetail implements Model
{
	private UnenrollProperty unenrollProperties;

	private String endDate;

	private Boolean automaticUnenroll;

	private String type;

	private ExecuteEvery executeEvery;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of unenrollProperties
	 * @return An instance of UnenrollProperty
	 */
	public UnenrollProperty getUnenrollProperties()
	{
		return  this.unenrollProperties;

	}

	/**
	 * The method to set the value to unenrollProperties
	 * @param unenrollProperties An instance of UnenrollProperty
	 */
	public void setUnenrollProperties(UnenrollProperty unenrollProperties)
	{
		 this.unenrollProperties = unenrollProperties;

		 this.keyModified.put("unenroll_properties", 1);

	}

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
	 * The method to get the value of automaticUnenroll
	 * @return A Boolean representing the automaticUnenroll
	 */
	public Boolean getAutomaticUnenroll()
	{
		return  this.automaticUnenroll;

	}

	/**
	 * The method to set the value to automaticUnenroll
	 * @param automaticUnenroll A Boolean representing the automaticUnenroll
	 */
	public void setAutomaticUnenroll(Boolean automaticUnenroll)
	{
		 this.automaticUnenroll = automaticUnenroll;

		 this.keyModified.put("automatic_unenroll", 1);

	}

	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of executeEvery
	 * @return An instance of ExecuteEvery
	 */
	public ExecuteEvery getExecuteEvery()
	{
		return  this.executeEvery;

	}

	/**
	 * The method to set the value to executeEvery
	 * @param executeEvery An instance of ExecuteEvery
	 */
	public void setExecuteEvery(ExecuteEvery executeEvery)
	{
		 this.executeEvery = executeEvery;

		 this.keyModified.put("execute_every", 1);

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