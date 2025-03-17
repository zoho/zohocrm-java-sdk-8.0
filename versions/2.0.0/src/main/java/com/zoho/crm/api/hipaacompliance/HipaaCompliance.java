package com.zoho.crm.api.hipaacompliance;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class HipaaCompliance implements Model
{
	private Boolean enabled;

	private List<Modules> enabledForModules;

	private Boolean restrictToZohoApps;

	private Boolean restrictDataAccessThroughAPI;

	private Boolean restrictDataInExport;

	private List<String> restrictToThirdPartyApps;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of enabled
	 * @return A Boolean representing the enabled
	 */
	public Boolean getEnabled()
	{
		return  this.enabled;

	}

	/**
	 * The method to set the value to enabled
	 * @param enabled A Boolean representing the enabled
	 */
	public void setEnabled(Boolean enabled)
	{
		 this.enabled = enabled;

		 this.keyModified.put("enabled", 1);

	}

	/**
	 * The method to get the value of enabledForModules
	 * @return An instance of List<Modules>
	 */
	public List<Modules> getEnabledForModules()
	{
		return  this.enabledForModules;

	}

	/**
	 * The method to set the value to enabledForModules
	 * @param enabledForModules An instance of List<Modules>
	 */
	public void setEnabledForModules(List<Modules> enabledForModules)
	{
		 this.enabledForModules = enabledForModules;

		 this.keyModified.put("enabled_for_modules", 1);

	}

	/**
	 * The method to get the value of restrictToZohoApps
	 * @return A Boolean representing the restrictToZohoApps
	 */
	public Boolean getRestrictToZohoApps()
	{
		return  this.restrictToZohoApps;

	}

	/**
	 * The method to set the value to restrictToZohoApps
	 * @param restrictToZohoApps A Boolean representing the restrictToZohoApps
	 */
	public void setRestrictToZohoApps(Boolean restrictToZohoApps)
	{
		 this.restrictToZohoApps = restrictToZohoApps;

		 this.keyModified.put("restrict_to_zoho_apps", 1);

	}

	/**
	 * The method to get the value of restrictDataAccessThroughapi
	 * @return A Boolean representing the restrictDataAccessThroughAPI
	 */
	public Boolean getRestrictDataAccessThroughAPI()
	{
		return  this.restrictDataAccessThroughAPI;

	}

	/**
	 * The method to set the value to restrictDataAccessThroughapi
	 * @param restrictDataAccessThroughAPI A Boolean representing the restrictDataAccessThroughAPI
	 */
	public void setRestrictDataAccessThroughAPI(Boolean restrictDataAccessThroughAPI)
	{
		 this.restrictDataAccessThroughAPI = restrictDataAccessThroughAPI;

		 this.keyModified.put("restrict_data_access_through_api", 1);

	}

	/**
	 * The method to get the value of restrictDataInExport
	 * @return A Boolean representing the restrictDataInExport
	 */
	public Boolean getRestrictDataInExport()
	{
		return  this.restrictDataInExport;

	}

	/**
	 * The method to set the value to restrictDataInExport
	 * @param restrictDataInExport A Boolean representing the restrictDataInExport
	 */
	public void setRestrictDataInExport(Boolean restrictDataInExport)
	{
		 this.restrictDataInExport = restrictDataInExport;

		 this.keyModified.put("restrict_data_in_export", 1);

	}

	/**
	 * The method to get the value of restrictToThirdPartyApps
	 * @return An instance of List<String>
	 */
	public List<String> getRestrictToThirdPartyApps()
	{
		return  this.restrictToThirdPartyApps;

	}

	/**
	 * The method to set the value to restrictToThirdPartyApps
	 * @param restrictToThirdPartyApps An instance of List<String>
	 */
	public void setRestrictToThirdPartyApps(List<String> restrictToThirdPartyApps)
	{
		 this.restrictToThirdPartyApps = restrictToThirdPartyApps;

		 this.keyModified.put("restrict_to_third_party_apps", 1);

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