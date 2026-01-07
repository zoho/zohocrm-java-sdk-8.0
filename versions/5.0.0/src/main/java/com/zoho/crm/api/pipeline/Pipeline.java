package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Pipeline implements Model
{
	private String displayValue;

	private Boolean default1;

	private List<Maps> maps;

	private String actualValue;

	private Long id;

	private Boolean childAvailable;

	private Pipeline parent;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of displayValue
	 * @return A String representing the displayValue
	 */
	public String getDisplayValue()
	{
		return  this.displayValue;

	}

	/**
	 * The method to set the value to displayValue
	 * @param displayValue A String representing the displayValue
	 */
	public void setDisplayValue(String displayValue)
	{
		 this.displayValue = displayValue;

		 this.keyModified.put("display_value", 1);

	}

	/**
	 * The method to get the value of default
	 * @return A Boolean representing the default1
	 */
	public Boolean getDefault()
	{
		return  this.default1;

	}

	/**
	 * The method to set the value to default
	 * @param default1 A Boolean representing the default1
	 */
	public void setDefault(Boolean default1)
	{
		 this.default1 = default1;

		 this.keyModified.put("default", 1);

	}

	/**
	 * The method to get the value of maps
	 * @return An instance of List<Maps>
	 */
	public List<Maps> getMaps()
	{
		return  this.maps;

	}

	/**
	 * The method to set the value to maps
	 * @param maps An instance of List<Maps>
	 */
	public void setMaps(List<Maps> maps)
	{
		 this.maps = maps;

		 this.keyModified.put("maps", 1);

	}

	/**
	 * The method to get the value of actualValue
	 * @return A String representing the actualValue
	 */
	public String getActualValue()
	{
		return  this.actualValue;

	}

	/**
	 * The method to set the value to actualValue
	 * @param actualValue A String representing the actualValue
	 */
	public void setActualValue(String actualValue)
	{
		 this.actualValue = actualValue;

		 this.keyModified.put("actual_value", 1);

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
	 * The method to get the value of childAvailable
	 * @return A Boolean representing the childAvailable
	 */
	public Boolean getChildAvailable()
	{
		return  this.childAvailable;

	}

	/**
	 * The method to set the value to childAvailable
	 * @param childAvailable A Boolean representing the childAvailable
	 */
	public void setChildAvailable(Boolean childAvailable)
	{
		 this.childAvailable = childAvailable;

		 this.keyModified.put("child_available", 1);

	}

	/**
	 * The method to get the value of parent
	 * @return An instance of Pipeline
	 */
	public Pipeline getParent()
	{
		return  this.parent;

	}

	/**
	 * The method to set the value to parent
	 * @param parent An instance of Pipeline
	 */
	public void setParent(Pipeline parent)
	{
		 this.parent = parent;

		 this.keyModified.put("parent", 1);

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