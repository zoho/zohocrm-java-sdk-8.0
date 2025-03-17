package com.zoho.crm.api.massconvert;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ErrorDetails implements Model
{
	private String apiName;

	private String jsonPath;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of jsonPath
	 * @return A String representing the jsonPath
	 */
	public String getJsonPath()
	{
		return  this.jsonPath;

	}

	/**
	 * The method to set the value to jsonPath
	 * @param jsonPath A String representing the jsonPath
	 */
	public void setJsonPath(String jsonPath)
	{
		 this.jsonPath = jsonPath;

		 this.keyModified.put("json_path", 1);

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