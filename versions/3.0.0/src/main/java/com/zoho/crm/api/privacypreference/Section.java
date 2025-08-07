package com.zoho.crm.api.privacypreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Section implements Model
{
	private String name;

	private String tooltip;

	private String showType;

	private String title;

	private List<Option> options;

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
	 * The method to get the value of showType
	 * @return A String representing the showType
	 */
	public String getShowType()
	{
		return  this.showType;

	}

	/**
	 * The method to set the value to showType
	 * @param showType A String representing the showType
	 */
	public void setShowType(String showType)
	{
		 this.showType = showType;

		 this.keyModified.put("show_type", 1);

	}

	/**
	 * The method to get the value of title
	 * @return A String representing the title
	 */
	public String getTitle()
	{
		return  this.title;

	}

	/**
	 * The method to set the value to title
	 * @param title A String representing the title
	 */
	public void setTitle(String title)
	{
		 this.title = title;

		 this.keyModified.put("title", 1);

	}

	/**
	 * The method to get the value of options
	 * @return An instance of List<Option>
	 */
	public List<Option> getOptions()
	{
		return  this.options;

	}

	/**
	 * The method to set the value to options
	 * @param options An instance of List<Option>
	 */
	public void setOptions(List<Option> options)
	{
		 this.options = options;

		 this.keyModified.put("options", 1);

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