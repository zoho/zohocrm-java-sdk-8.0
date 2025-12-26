package com.zoho.crm.api.recordlocking;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class LockRecord implements Model
{
	private String lockedReasonS;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of lockedReasonS
	 * @return A String representing the lockedReasonS
	 */
	public String getLockedReasonS()
	{
		return  this.lockedReasonS;

	}

	/**
	 * The method to set the value to lockedReasonS
	 * @param lockedReasonS A String representing the lockedReasonS
	 */
	public void setLockedReasonS(String lockedReasonS)
	{
		 this.lockedReasonS = lockedReasonS;

		 this.keyModified.put("Locked_Reason__s", 1);

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