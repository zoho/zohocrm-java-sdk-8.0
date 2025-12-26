package com.zoho.crm.api.sendmail;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class InventoryDetails implements Model
{
	private InventoryTemplate inventoryTemplate;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of inventoryTemplate
	 * @return An instance of InventoryTemplate
	 */
	public InventoryTemplate getInventoryTemplate()
	{
		return  this.inventoryTemplate;

	}

	/**
	 * The method to set the value to inventoryTemplate
	 * @param inventoryTemplate An instance of InventoryTemplate
	 */
	public void setInventoryTemplate(InventoryTemplate inventoryTemplate)
	{
		 this.inventoryTemplate = inventoryTemplate;

		 this.keyModified.put("inventory_template", 1);

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