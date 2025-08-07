package com.zoho.crm.api.conversionoption;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class PreferenceFieldMatch implements Model
{
	private Field field;

	private String matchedLeadValue;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of matchedLeadValue
	 * @return A String representing the matchedLeadValue
	 */
	public String getMatchedLeadValue()
	{
		return  this.matchedLeadValue;

	}

	/**
	 * The method to set the value to matchedLeadValue
	 * @param matchedLeadValue A String representing the matchedLeadValue
	 */
	public void setMatchedLeadValue(String matchedLeadValue)
	{
		 this.matchedLeadValue = matchedLeadValue;

		 this.keyModified.put("matched_lead_value", 1);

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