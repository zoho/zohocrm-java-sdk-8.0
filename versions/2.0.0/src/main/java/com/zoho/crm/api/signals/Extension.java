package com.zoho.crm.api.signals;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Extension implements Model
{
	private String displayLabel;

	private String namespace;

	private Long id;

	private Integer type;

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
	 * The method to get the value of namespace
	 * @return A String representing the namespace
	 */
	public String getNamespace()
	{
		return  this.namespace;

	}

	/**
	 * The method to set the value to namespace
	 * @param namespace A String representing the namespace
	 */
	public void setNamespace(String namespace)
	{
		 this.namespace = namespace;

		 this.keyModified.put("namespace", 1);

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
	 * The method to get the value of type
	 * @return An Integer representing the type
	 */
	public Integer getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An Integer representing the type
	 */
	public void setType(Integer type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

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