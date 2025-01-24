package com.zoho.crm.api.privacypreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Wrapper implements Model
{
	private List<PrivacyPreference> privacypreference;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of privacypreference
	 * @return An instance of List<PrivacyPreference>
	 */
	public List<PrivacyPreference> getPrivacypreference()
	{
		return  this.privacypreference;

	}

	/**
	 * The method to set the value to privacypreference
	 * @param privacypreference An instance of List<PrivacyPreference>
	 */
	public void setPrivacypreference(List<PrivacyPreference> privacypreference)
	{
		 this.privacypreference = privacypreference;

		 this.keyModified.put("privacyPreference", 1);

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