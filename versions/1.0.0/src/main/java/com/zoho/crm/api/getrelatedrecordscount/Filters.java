package com.zoho.crm.api.getrelatedrecordscount;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Filters implements Model
{
	private Choice<String> comparator;

	private Field field;

	private String value;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of comparator
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getComparator()
	{
		return  this.comparator;

	}

	/**
	 * The method to set the value to comparator
	 * @param comparator An instance of Choice<String>
	 */
	public void setComparator(Choice<String> comparator)
	{
		 this.comparator = comparator;

		 this.keyModified.put("comparator", 1);

	}

	/**
	 * The method to get the value of field
	 * @return An instance of Field
	 */
	public Field getField()
	{
		return  this.field;

	}

	/**
	 * The method to set the value to field
	 * @param field An instance of Field
	 */
	public void setField(Field field)
	{
		 this.field = field;

		 this.keyModified.put("field", 1);

	}

	/**
	 * The method to get the value of value
	 * @return A String representing the value
	 */
	public String getValue()
	{
		return  this.value;

	}

	/**
	 * The method to set the value to value
	 * @param value A String representing the value
	 */
	public void setValue(String value)
	{
		 this.value = value;

		 this.keyModified.put("value", 1);

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