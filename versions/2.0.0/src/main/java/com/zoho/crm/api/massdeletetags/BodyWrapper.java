package com.zoho.crm.api.massdeletetags;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<MassDelete> massDelete;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of massDelete
	 * @return An instance of List<MassDelete>
	 */
	public List<MassDelete> getMassDelete()
	{
		return  this.massDelete;

	}

	/**
	 * The method to set the value to massDelete
	 * @param massDelete An instance of List<MassDelete>
	 */
	public void setMassDelete(List<MassDelete> massDelete)
	{
		 this.massDelete = massDelete;

		 this.keyModified.put("mass_delete", 1);

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