package com.zoho.crm.api.modules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class MinifiedModule implements Model
{
	private String apiName;

	private Long id;

	private String moduleName;

	private String module;

	private Boolean crypt;

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
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of moduleName
	 * @return A String representing the moduleName
	 */
	public String getModuleName()
	{
		return  this.moduleName;

	}

	/**
	 * The method to set the value to moduleName
	 * @param moduleName A String representing the moduleName
	 */
	public void setModuleName(String moduleName)
	{
		 this.moduleName = moduleName;

		 this.keyModified.put("module_name", 1);

	}

	/**
	 * The method to get the value of module
	 * @return A String representing the module
	 */
	public String getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module A String representing the module
	 */
	public void setModule(String module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of crypt
	 * @return A Boolean representing the crypt
	 */
	public Boolean getCrypt()
	{
		return  this.crypt;

	}

	/**
	 * The method to set the value to crypt
	 * @param crypt A Boolean representing the crypt
	 */
	public void setCrypt(Boolean crypt)
	{
		 this.crypt = crypt;

		 this.keyModified.put("crypt", 1);

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