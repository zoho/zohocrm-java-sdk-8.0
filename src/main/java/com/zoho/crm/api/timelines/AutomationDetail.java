package com.zoho.crm.api.timelines;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class AutomationDetail implements Model
{
	private String type;

	private NameIdStructure rule;

	private PathFinder pathfinder;

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
	 * The method to get the value of rule
	 * @return An instance of NameIdStructure
	 */
	public NameIdStructure getRule()
	{
		return  this.rule;

	}

	/**
	 * The method to set the value to rule
	 * @param rule An instance of NameIdStructure
	 */
	public void setRule(NameIdStructure rule)
	{
		 this.rule = rule;

		 this.keyModified.put("rule", 1);

	}

	/**
	 * The method to get the value of pathfinder
	 * @return An instance of PathFinder
	 */
	public PathFinder getPathfinder()
	{
		return  this.pathfinder;

	}

	/**
	 * The method to set the value to pathfinder
	 * @param pathfinder An instance of PathFinder
	 */
	public void setPathfinder(PathFinder pathfinder)
	{
		 this.pathfinder = pathfinder;

		 this.keyModified.put("pathfinder", 1);

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