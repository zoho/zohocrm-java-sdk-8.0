package com.zoho.crm.api.inventoryconvert;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ConvertTo implements Model
{
	private Module module;

	private Boolean carryOverTags;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of module
	 * @return An instance of Module
	 */
	public Module getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Module
	 */
	public void setModule(Module module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of carryOverTags
	 * @return A Boolean representing the carryOverTags
	 */
	public Boolean getCarryOverTags()
	{
		return  this.carryOverTags;

	}

	/**
	 * The method to set the value to carryOverTags
	 * @param carryOverTags A Boolean representing the carryOverTags
	 */
	public void setCarryOverTags(Boolean carryOverTags)
	{
		 this.carryOverTags = carryOverTags;

		 this.keyModified.put("carry_over_tags", 1);

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