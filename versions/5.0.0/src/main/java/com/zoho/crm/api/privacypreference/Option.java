package com.zoho.crm.api.privacypreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Option implements Model
{
	private String name;

	private String tooltip;

	private String type;

	private List<String> suboptions;

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
	 * The method to get the value of tooltip
	 * @return A String representing the tooltip
	 */
	public String getTooltip()
	{
		return  this.tooltip;

	}

	/**
	 * The method to set the value to tooltip
	 * @param tooltip A String representing the tooltip
	 */
	public void setTooltip(String tooltip)
	{
		 this.tooltip = tooltip;

		 this.keyModified.put("tooltip", 1);

	}

	/**
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of suboptions
	 * @return An instance of List<String>
	 */
	public List<String> getSuboptions()
	{
		return  this.suboptions;

	}

	/**
	 * The method to set the value to suboptions
	 * @param suboptions An instance of List<String>
	 */
	public void setSuboptions(List<String> suboptions)
	{
		 this.suboptions = suboptions;

		 this.keyModified.put("suboptions", 1);

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