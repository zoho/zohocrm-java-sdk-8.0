package com.zoho.crm.api.duplicatecheckpreference;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class DuplicateCheckPreference implements Model
{
	private Choice<String> type;

	private List<TypeConfiguration> typeConfigurations;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of typeConfigurations
	 * @return An instance of List<TypeConfiguration>
	 */
	public List<TypeConfiguration> getTypeConfigurations()
	{
		return  this.typeConfigurations;

	}

	/**
	 * The method to set the value to typeConfigurations
	 * @param typeConfigurations An instance of List<TypeConfiguration>
	 */
	public void setTypeConfigurations(List<TypeConfiguration> typeConfigurations)
	{
		 this.typeConfigurations = typeConfigurations;

		 this.keyModified.put("type_configurations", 1);

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