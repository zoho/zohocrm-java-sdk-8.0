package com.zoho.crm.api.webforms;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class FormSection implements Model
{
	private List<Fields> formFields;

	private String name;

	private String description;

	private String helpMessage;

	private String id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of formFields
	 * @return An instance of List<Fields>
	 */
	public List<Fields> getFormFields()
	{
		return  this.formFields;

	}

	/**
	 * The method to set the value to formFields
	 * @param formFields An instance of List<Fields>
	 */
	public void setFormFields(List<Fields> formFields)
	{
		 this.formFields = formFields;

		 this.keyModified.put("form_fields", 1);

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
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.description = description;

		 this.keyModified.put("description", 1);

	}

	/**
	 * The method to get the value of helpMessage
	 * @return A String representing the helpMessage
	 */
	public String getHelpMessage()
	{
		return  this.helpMessage;

	}

	/**
	 * The method to set the value to helpMessage
	 * @param helpMessage A String representing the helpMessage
	 */
	public void setHelpMessage(String helpMessage)
	{
		 this.helpMessage = helpMessage;

		 this.keyModified.put("help_message", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
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