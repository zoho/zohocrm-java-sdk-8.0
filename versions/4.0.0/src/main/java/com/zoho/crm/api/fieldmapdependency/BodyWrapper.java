package com.zoho.crm.api.fieldmapdependency;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<MapDependency> mapDependency;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of mapDependency
	 * @return An instance of List<MapDependency>
	 */
	public List<MapDependency> getMapDependency()
	{
		return  this.mapDependency;

	}

	/**
	 * The method to set the value to mapDependency
	 * @param mapDependency An instance of List<MapDependency>
	 */
	public void setMapDependency(List<MapDependency> mapDependency)
	{
		 this.mapDependency = mapDependency;

		 this.keyModified.put("map_dependency", 1);

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