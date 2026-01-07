package com.zoho.crm.api.timelines;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class PathFinder implements Model
{
	private Boolean processEntry;

	private Boolean processExit;

	private State state;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of processEntry
	 * @return A Boolean representing the processEntry
	 */
	public Boolean getProcessEntry()
	{
		return  this.processEntry;

	}

	/**
	 * The method to set the value to processEntry
	 * @param processEntry A Boolean representing the processEntry
	 */
	public void setProcessEntry(Boolean processEntry)
	{
		 this.processEntry = processEntry;

		 this.keyModified.put("process_entry", 1);

	}

	/**
	 * The method to get the value of processExit
	 * @return A Boolean representing the processExit
	 */
	public Boolean getProcessExit()
	{
		return  this.processExit;

	}

	/**
	 * The method to set the value to processExit
	 * @param processExit A Boolean representing the processExit
	 */
	public void setProcessExit(Boolean processExit)
	{
		 this.processExit = processExit;

		 this.keyModified.put("process_exit", 1);

	}

	/**
	 * The method to get the value of state
	 * @return An instance of State
	 */
	public State getState()
	{
		return  this.state;

	}

	/**
	 * The method to set the value to state
	 * @param state An instance of State
	 */
	public void setState(State state)
	{
		 this.state = state;

		 this.keyModified.put("state", 1);

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