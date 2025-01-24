package com.zoho.crm.api.usergroups;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Sources implements Model
{
	private Choice<String> type;

	private Source source;

	private Boolean subordinates;

	private Boolean subTerritories;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of source
	 * @return An instance of Source
	 */
	public Source getSource()
	{
		return  this.source;

	}

	/**
	 * The method to set the value to source
	 * @param source An instance of Source
	 */
	public void setSource(Source source)
	{
		 this.source = source;

		 this.keyModified.put("source", 1);

	}

	/**
	 * The method to get the value of subordinates
	 * @return A Boolean representing the subordinates
	 */
	public Boolean getSubordinates()
	{
		return  this.subordinates;

	}

	/**
	 * The method to set the value to subordinates
	 * @param subordinates A Boolean representing the subordinates
	 */
	public void setSubordinates(Boolean subordinates)
	{
		 this.subordinates = subordinates;

		 this.keyModified.put("subordinates", 1);

	}

	/**
	 * The method to get the value of subTerritories
	 * @return A Boolean representing the subTerritories
	 */
	public Boolean getSubTerritories()
	{
		return  this.subTerritories;

	}

	/**
	 * The method to set the value to subTerritories
	 * @param subTerritories A Boolean representing the subTerritories
	 */
	public void setSubTerritories(Boolean subTerritories)
	{
		 this.subTerritories = subTerritories;

		 this.keyModified.put("sub_territories", 1);

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