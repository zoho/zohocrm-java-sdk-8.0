package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ShowFields implements Model
{
	private Boolean showData;

	private MinifiedField field;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of showData
	 * @return A Boolean representing the showData
	 */
	public Boolean getShowData()
	{
		return  this.showData;

	}

	/**
	 * The method to set the value to showData
	 * @param showData A Boolean representing the showData
	 */
	public void setShowData(Boolean showData)
	{
		 this.showData = showData;

		 this.keyModified.put("show_data", 1);

	}

	/**
	 * The method to get the value of field
	 * @return An instance of MinifiedField
	 */
	public MinifiedField getField()
	{
		return  this.field;

	}

	/**
	 * The method to set the value to field
	 * @param field An instance of MinifiedField
	 */
	public void setField(MinifiedField field)
	{
		 this.field = field;

		 this.keyModified.put("field", 1);

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