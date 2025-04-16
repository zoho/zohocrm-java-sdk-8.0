package com.zoho.crm.api.layouts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Profiles implements Model
{
	private Boolean default1;

	private String name;

	private Long id;

	private DefaultView defaultView;

	private DefaultAssignmentView defaultAssignmentView;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of defaultView
	 * @return An instance of DefaultView
	 */
	public DefaultView getDefaultView()
	{
		return  this.defaultView;

	}

	/**
	 * The method to set the value to defaultView
	 * @param defaultView An instance of DefaultView
	 */
	public void setDefaultView(DefaultView defaultView)
	{
		 this.defaultView = defaultView;

		 this.keyModified.put("_default_view", 1);

	}

	/**
	 * The method to get the value of defaultAssignmentView
	 * @return An instance of DefaultAssignmentView
	 */
	public DefaultAssignmentView getDefaultAssignmentView()
	{
		return  this.defaultAssignmentView;

	}

	/**
	 * The method to set the value to defaultAssignmentView
	 * @param defaultAssignmentView An instance of DefaultAssignmentView
	 */
	public void setDefaultAssignmentView(DefaultAssignmentView defaultAssignmentView)
	{
		 this.defaultAssignmentView = defaultAssignmentView;

		 this.keyModified.put("_default_assignment_view", 1);

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