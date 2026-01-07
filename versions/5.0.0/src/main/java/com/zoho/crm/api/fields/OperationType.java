package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class OperationType implements Model
{
	private Boolean webUpdate;

	private Boolean apiCreate;

	private Boolean webCreate;

	private Boolean apiUpdate;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of webUpdate
	 * @return A Boolean representing the webUpdate
	 */
	public Boolean getWebUpdate()
	{
		return  this.webUpdate;

	}

	/**
	 * The method to set the value to webUpdate
	 * @param webUpdate A Boolean representing the webUpdate
	 */
	public void setWebUpdate(Boolean webUpdate)
	{
		 this.webUpdate = webUpdate;

		 this.keyModified.put("web_update", 1);

	}

	/**
	 * The method to get the value of apiCreate
	 * @return A Boolean representing the apiCreate
	 */
	public Boolean getAPICreate()
	{
		return  this.apiCreate;

	}

	/**
	 * The method to set the value to apiCreate
	 * @param apiCreate A Boolean representing the apiCreate
	 */
	public void setAPICreate(Boolean apiCreate)
	{
		 this.apiCreate = apiCreate;

		 this.keyModified.put("api_create", 1);

	}

	/**
	 * The method to get the value of webCreate
	 * @return A Boolean representing the webCreate
	 */
	public Boolean getWebCreate()
	{
		return  this.webCreate;

	}

	/**
	 * The method to set the value to webCreate
	 * @param webCreate A Boolean representing the webCreate
	 */
	public void setWebCreate(Boolean webCreate)
	{
		 this.webCreate = webCreate;

		 this.keyModified.put("web_create", 1);

	}

	/**
	 * The method to get the value of apiUpdate
	 * @return A Boolean representing the apiUpdate
	 */
	public Boolean getAPIUpdate()
	{
		return  this.apiUpdate;

	}

	/**
	 * The method to set the value to apiUpdate
	 * @param apiUpdate A Boolean representing the apiUpdate
	 */
	public void setAPIUpdate(Boolean apiUpdate)
	{
		 this.apiUpdate = apiUpdate;

		 this.keyModified.put("api_update", 1);

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