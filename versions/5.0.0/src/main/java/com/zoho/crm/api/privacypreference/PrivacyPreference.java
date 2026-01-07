package com.zoho.crm.api.privacypreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class PrivacyPreference implements Model
{
	private Preference preference;

	private Config config;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of preference
	 * @return An instance of Preference
	 */
	public Preference getPreference()
	{
		return  this.preference;

	}

	/**
	 * The method to set the value to preference
	 * @param preference An instance of Preference
	 */
	public void setPreference(Preference preference)
	{
		 this.preference = preference;

		 this.keyModified.put("preference", 1);

	}

	/**
	 * The method to get the value of config
	 * @return An instance of Config
	 */
	public Config getConfig()
	{
		return  this.config;

	}

	/**
	 * The method to set the value to config
	 * @param config An instance of Config
	 */
	public void setConfig(Config config)
	{
		 this.config = config;

		 this.keyModified.put("config", 1);

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