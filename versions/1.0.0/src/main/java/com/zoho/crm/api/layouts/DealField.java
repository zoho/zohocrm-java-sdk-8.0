package com.zoho.crm.api.layouts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class DealField implements Model
{
	private String apiName;

	private String fieldLabel;

	private Long id;

	private Boolean required;

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
	 * The method to get the value of fieldLabel
	 * @return A String representing the fieldLabel
	 */
	public String getFieldLabel()
	{
		return  this.fieldLabel;

	}

	/**
	 * The method to set the value to fieldLabel
	 * @param fieldLabel A String representing the fieldLabel
	 */
	public void setFieldLabel(String fieldLabel)
	{
		 this.fieldLabel = fieldLabel;

		 this.keyModified.put("field_label", 1);

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