package com.zoho.crm.api.emailconfigurationoptions;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ValueDetails implements Model
{
	private String type;

	private Object value;

	private Boolean delete;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of value
	 * @return An instance of Object
	 */
	public Object getValue()
	{
		return  this.value;

	}

	/**
	 * The method to set the value to value
	 * @param value An instance of Object
	 */
	public void setValue(Object value)
	{
		 this.value = value;

		 this.keyModified.put("value", 1);

	}

	/**
	 * The method to get the value of delete
	 * @return A Boolean representing the delete
	 */
	public Boolean getDelete()
	{
		return  this.delete;

	}

	/**
	 * The method to set the value to delete
	 * @param delete A Boolean representing the delete
	 */
	public void setDelete(Boolean delete)
	{
		 this.delete = delete;

		 this.keyModified.put("_delete", 1);

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