package com.zoho.crm.api.massdeletecvid;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class CvidBodyWrapper implements Model
{
	private Long cvid;

	private Territory territory;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of cvid
	 * @return A Long representing the cvid
	 */
	public Long getCvid()
	{
		return  this.cvid;

	}

	/**
	 * The method to set the value to cvid
	 * @param cvid A Long representing the cvid
	 */
	public void setCvid(Long cvid)
	{
		 this.cvid = cvid;

		 this.keyModified.put("cvid", 1);

	}

	/**
	 * The method to get the value of territory
	 * @return An instance of Territory
	 */
	public Territory getTerritory()
	{
		return  this.territory;

	}

	/**
	 * The method to set the value to territory
	 * @param territory An instance of Territory
	 */
	public void setTerritory(Territory territory)
	{
		 this.territory = territory;

		 this.keyModified.put("territory", 1);

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