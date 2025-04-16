package com.zoho.crm.api.wizards;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ResponseWrapper implements Model, ResponseHandler
{
	private List<Wizard> wizards;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of wizards
	 * @return An instance of List<Wizard>
	 */
	public List<Wizard> getWizards()
	{
		return  this.wizards;

	}

	/**
	 * The method to set the value to wizards
	 * @param wizards An instance of List<Wizard>
	 */
	public void setWizards(List<Wizard> wizards)
	{
		 this.wizards = wizards;

		 this.keyModified.put("wizards", 1);

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