package com.zoho.crm.api.inventoryconvert;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class InventoryConverter implements Model
{
	private List<ConvertTo> convertTo;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of convertTo
	 * @return An instance of List<ConvertTo>
	 */
	public List<ConvertTo> getConvertTo()
	{
		return  this.convertTo;

	}

	/**
	 * The method to set the value to convertTo
	 * @param convertTo An instance of List<ConvertTo>
	 */
	public void setConvertTo(List<ConvertTo> convertTo)
	{
		 this.convertTo = convertTo;

		 this.keyModified.put("convert_to", 1);

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