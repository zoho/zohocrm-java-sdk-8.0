package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class LinkingModule implements Model
{
	private String pluralLabel;

	private Integer visibility;

	private String apiName;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of pluralLabel
	 * @return A String representing the pluralLabel
	 */
	public String getPluralLabel()
	{
		return  this.pluralLabel;

	}

	/**
	 * The method to set the value to pluralLabel
	 * @param pluralLabel A String representing the pluralLabel
	 */
	public void setPluralLabel(String pluralLabel)
	{
		 this.pluralLabel = pluralLabel;

		 this.keyModified.put("plural_label", 1);

	}

	/**
	 * The method to get the value of visibility
	 * @return An Integer representing the visibility
	 */
	public Integer getVisibility()
	{
		return  this.visibility;

	}

	/**
	 * The method to set the value to visibility
	 * @param visibility An Integer representing the visibility
	 */
	public void setVisibility(Integer visibility)
	{
		 this.visibility = visibility;

		 this.keyModified.put("visibility", 1);

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