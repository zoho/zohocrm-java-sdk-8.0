package com.zoho.crm.api.privacyconfigurableapps;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Wrapper implements Model
{
	private List<Apps> privacyConfigurableApps;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of privacyConfigurableApps
	 * @return An instance of List<Apps>
	 */
	public List<Apps> getPrivacyConfigurableApps()
	{
		return  this.privacyConfigurableApps;

	}

	/**
	 * The method to set the value to privacyConfigurableApps
	 * @param privacyConfigurableApps An instance of List<Apps>
	 */
	public void setPrivacyConfigurableApps(List<Apps> privacyConfigurableApps)
	{
		 this.privacyConfigurableApps = privacyConfigurableApps;

		 this.keyModified.put("privacy_configurable_apps", 1);

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