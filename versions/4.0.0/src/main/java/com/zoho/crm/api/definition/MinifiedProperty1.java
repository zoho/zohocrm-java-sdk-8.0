package com.zoho.crm.api.definition;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class MinifiedProperty1 implements Model
{
	private Boolean readOnly;

	private String apiName;

	private String dataType;

	private Integer length;

	private Boolean required;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of readOnly
	 * @return A Boolean representing the readOnly
	 */
	public Boolean getReadOnly()
	{
		return  this.readOnly;

	}

	/**
	 * The method to set the value to readOnly
	 * @param readOnly A Boolean representing the readOnly
	 */
	public void setReadOnly(Boolean readOnly)
	{
		 this.readOnly = readOnly;

		 this.keyModified.put("read_only", 1);

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
	 * The method to get the value of dataType
	 * @return A String representing the dataType
	 */
	public String getDataType()
	{
		return  this.dataType;

	}

	/**
	 * The method to set the value to dataType
	 * @param dataType A String representing the dataType
	 */
	public void setDataType(String dataType)
	{
		 this.dataType = dataType;

		 this.keyModified.put("data_type", 1);

	}

	/**
	 * The method to get the value of length
	 * @return An Integer representing the length
	 */
	public Integer getLength()
	{
		return  this.length;

	}

	/**
	 * The method to set the value to length
	 * @param length An Integer representing the length
	 */
	public void setLength(Integer length)
	{
		 this.length = length;

		 this.keyModified.put("length", 1);

	}

	/**
	 * The method to get the value of required
	 * @return A Boolean representing the required
	 */
	public Boolean getRequired()
	{
		return  this.required;

	}

	/**
	 * The method to set the value to required
	 * @param required A Boolean representing the required
	 */
	public void setRequired(Boolean required)
	{
		 this.required = required;

		 this.keyModified.put("required", 1);

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