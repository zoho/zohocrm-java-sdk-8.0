package com.zoho.crm.api.duplicatecheckpreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class FieldMappings implements Model
{
	private CurrentField currentField;

	private MappedField mappedField;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of currentField
	 * @return An instance of CurrentField
	 */
	public CurrentField getCurrentField()
	{
		return  this.currentField;

	}

	/**
	 * The method to set the value to currentField
	 * @param currentField An instance of CurrentField
	 */
	public void setCurrentField(CurrentField currentField)
	{
		 this.currentField = currentField;

		 this.keyModified.put("current_field", 1);

	}

	/**
	 * The method to get the value of mappedField
	 * @return An instance of MappedField
	 */
	public MappedField getMappedField()
	{
		return  this.mappedField;

	}

	/**
	 * The method to set the value to mappedField
	 * @param mappedField An instance of MappedField
	 */
	public void setMappedField(MappedField mappedField)
	{
		 this.mappedField = mappedField;

		 this.keyModified.put("mapped_field", 1);

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