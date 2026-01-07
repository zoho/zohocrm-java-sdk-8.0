package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class HipaaCompliance implements Model
{
	private Boolean restrictedInExport;

	private Boolean restricted;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of restrictedInExport
	 * @return A Boolean representing the restrictedInExport
	 */
	public Boolean getRestrictedInExport()
	{
		return  this.restrictedInExport;

	}

	/**
	 * The method to set the value to restrictedInExport
	 * @param restrictedInExport A Boolean representing the restrictedInExport
	 */
	public void setRestrictedInExport(Boolean restrictedInExport)
	{
		 this.restrictedInExport = restrictedInExport;

		 this.keyModified.put("restricted_in_export", 1);

	}

	/**
	 * The method to get the value of restricted
	 * @return A Boolean representing the restricted
	 */
	public Boolean getRestricted()
	{
		return  this.restricted;

	}

	/**
	 * The method to set the value to restricted
	 * @param restricted A Boolean representing the restricted
	 */
	public void setRestricted(Boolean restricted)
	{
		 this.restricted = restricted;

		 this.keyModified.put("restricted", 1);

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