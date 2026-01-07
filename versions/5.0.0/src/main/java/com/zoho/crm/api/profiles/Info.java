package com.zoho.crm.api.profiles;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Info implements Model
{
	private Integer licenseLimit;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of licenseLimit
	 * @return An Integer representing the licenseLimit
	 */
	public Integer getLicenseLimit()
	{
		return  this.licenseLimit;

	}

	/**
	 * The method to set the value to licenseLimit
	 * @param licenseLimit An Integer representing the licenseLimit
	 */
	public void setLicenseLimit(Integer licenseLimit)
	{
		 this.licenseLimit = licenseLimit;

		 this.keyModified.put("license_limit", 1);

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