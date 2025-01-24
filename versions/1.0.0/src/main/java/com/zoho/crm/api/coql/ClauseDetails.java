package com.zoho.crm.api.coql;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ClauseDetails implements Model, DetailsWrapper
{
	private String clause;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of clause
	 * @return A String representing the clause
	 */
	public String getClause()
	{
		return  this.clause;

	}

	/**
	 * The method to set the value to clause
	 * @param clause A String representing the clause
	 */
	public void setClause(String clause)
	{
		 this.clause = clause;

		 this.keyModified.put("clause", 1);

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