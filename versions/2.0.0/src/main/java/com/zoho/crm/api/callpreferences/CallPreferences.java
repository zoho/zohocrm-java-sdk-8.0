package com.zoho.crm.api.callpreferences;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class CallPreferences implements Model
{
	private Boolean showFromNumber;

	private Boolean showToNumber;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of showFromNumber
	 * @return A Boolean representing the showFromNumber
	 */
	public Boolean getShowFromNumber()
	{
		return  this.showFromNumber;

	}

	/**
	 * The method to set the value to showFromNumber
	 * @param showFromNumber A Boolean representing the showFromNumber
	 */
	public void setShowFromNumber(Boolean showFromNumber)
	{
		 this.showFromNumber = showFromNumber;

		 this.keyModified.put("show_from_number", 1);

	}

	/**
	 * The method to get the value of showToNumber
	 * @return A Boolean representing the showToNumber
	 */
	public Boolean getShowToNumber()
	{
		return  this.showToNumber;

	}

	/**
	 * The method to set the value to showToNumber
	 * @param showToNumber A Boolean representing the showToNumber
	 */
	public void setShowToNumber(Boolean showToNumber)
	{
		 this.showToNumber = showToNumber;

		 this.keyModified.put("show_to_number", 1);

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