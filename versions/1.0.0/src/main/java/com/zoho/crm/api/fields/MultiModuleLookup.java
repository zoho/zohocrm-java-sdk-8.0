package com.zoho.crm.api.fields;

import com.zoho.crm.api.modules.MinifiedModule;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class MultiModuleLookup implements Model
{
	private String displayLabel;

	private String apiName;

	private List<MinifiedModule> modules;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of displayLabel
	 * @return A String representing the displayLabel
	 */
	public String getDisplayLabel()
	{
		return  this.displayLabel;

	}

	/**
	 * The method to set the value to displayLabel
	 * @param displayLabel A String representing the displayLabel
	 */
	public void setDisplayLabel(String displayLabel)
	{
		 this.displayLabel = displayLabel;

		 this.keyModified.put("display_label", 1);

	}

	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

	}

	/**
	 * The method to get the value of modules
	 * @return An instance of List<MinifiedModule>
	 */
	public List<MinifiedModule> getModules()
	{
		return  this.modules;

	}

	/**
	 * The method to set the value to modules
	 * @param modules An instance of List<MinifiedModule>
	 */
	public void setModules(List<MinifiedModule> modules)
	{
		 this.modules = modules;

		 this.keyModified.put("modules", 1);

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