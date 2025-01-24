package com.zoho.crm.api.emailconfigurationoptions;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ConfigurationOptions implements Model
{
	private String name;

	private List<ValueDetails> values;

	private Choice<String> dataType;

	private List<PropertyDetails> properties;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of values
	 * @return An instance of List<ValueDetails>
	 */
	public List<ValueDetails> getValues()
	{
		return  this.values;

	}

	/**
	 * The method to set the value to values
	 * @param values An instance of List<ValueDetails>
	 */
	public void setValues(List<ValueDetails> values)
	{
		 this.values = values;

		 this.keyModified.put("values", 1);

	}

	/**
	 * The method to get the value of dataType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getDataType()
	{
		return  this.dataType;

	}

	/**
	 * The method to set the value to dataType
	 * @param dataType An instance of Choice<String>
	 */
	public void setDataType(Choice<String> dataType)
	{
		 this.dataType = dataType;

		 this.keyModified.put("data_type", 1);

	}

	/**
	 * The method to get the value of properties
	 * @return An instance of List<PropertyDetails>
	 */
	public List<PropertyDetails> getProperties()
	{
		return  this.properties;

	}

	/**
	 * The method to set the value to properties
	 * @param properties An instance of List<PropertyDetails>
	 */
	public void setProperties(List<PropertyDetails> properties)
	{
		 this.properties = properties;

		 this.keyModified.put("properties", 1);

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