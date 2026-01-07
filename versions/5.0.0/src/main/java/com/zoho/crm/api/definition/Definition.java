package com.zoho.crm.api.definition;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Definition implements Model
{
	private String rootElementName;

	private Map<String, Object> extradetails;

	private List<Property> properties;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of rootElementName
	 * @return A String representing the rootElementName
	 */
	public String getRootElementName()
	{
		return  this.rootElementName;

	}

	/**
	 * The method to set the value to rootElementName
	 * @param rootElementName A String representing the rootElementName
	 */
	public void setRootElementName(String rootElementName)
	{
		 this.rootElementName = rootElementName;

		 this.keyModified.put("root_element_name", 1);

	}

	/**
	 * The method to get the value of extradetails
	 * @return An instance of Map<String,Object>
	 */
	public Map<String, Object> getExtradetails()
	{
		return  this.extradetails;

	}

	/**
	 * The method to set the value to extradetails
	 * @param extradetails An instance of Map<String,Object>
	 */
	public void setExtradetails(Map<String, Object> extradetails)
	{
		 this.extradetails = extradetails;

		 this.keyModified.put("extraDetails", 1);

	}

	/**
	 * The method to get the value of properties
	 * @return An instance of List<Property>
	 */
	public List<Property> getProperties()
	{
		return  this.properties;

	}

	/**
	 * The method to set the value to properties
	 * @param properties An instance of List<Property>
	 */
	public void setProperties(List<Property> properties)
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