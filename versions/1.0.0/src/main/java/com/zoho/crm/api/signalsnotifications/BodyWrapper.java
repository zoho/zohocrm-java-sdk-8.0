package com.zoho.crm.api.signalsnotifications;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<Signals> signals;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of signals
	 * @return An instance of List<Signals>
	 */
	public List<Signals> getSignals()
	{
		return  this.signals;

	}

	/**
	 * The method to set the value to signals
	 * @param signals An instance of List<Signals>
	 */
	public void setSignals(List<Signals> signals)
	{
		 this.signals = signals;

		 this.keyModified.put("signals", 1);

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