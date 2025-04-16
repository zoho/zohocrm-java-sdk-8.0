package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class SharingProperties implements Model
{
	private String schedulerStatus;

	private Boolean sharePreferenceEnabled;

	private Choice<String> sharePermission;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of schedulerStatus
	 * @return A String representing the schedulerStatus
	 */
	public String getSchedulerStatus()
	{
		return  this.schedulerStatus;

	}

	/**
	 * The method to set the value to schedulerStatus
	 * @param schedulerStatus A String representing the schedulerStatus
	 */
	public void setSchedulerStatus(String schedulerStatus)
	{
		 this.schedulerStatus = schedulerStatus;

		 this.keyModified.put("scheduler_status", 1);

	}

	/**
	 * The method to get the value of sharePreferenceEnabled
	 * @return A Boolean representing the sharePreferenceEnabled
	 */
	public Boolean getSharePreferenceEnabled()
	{
		return  this.sharePreferenceEnabled;

	}

	/**
	 * The method to set the value to sharePreferenceEnabled
	 * @param sharePreferenceEnabled A Boolean representing the sharePreferenceEnabled
	 */
	public void setSharePreferenceEnabled(Boolean sharePreferenceEnabled)
	{
		 this.sharePreferenceEnabled = sharePreferenceEnabled;

		 this.keyModified.put("share_preference_enabled", 1);

	}

	/**
	 * The method to get the value of sharePermission
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getSharePermission()
	{
		return  this.sharePermission;

	}

	/**
	 * The method to set the value to sharePermission
	 * @param sharePermission An instance of Choice<String>
	 */
	public void setSharePermission(Choice<String> sharePermission)
	{
		 this.sharePermission = sharePermission;

		 this.keyModified.put("share_permission", 1);

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