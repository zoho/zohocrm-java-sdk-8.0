package com.zoho.crm.api.signals;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class FeatureAvailability implements Model
{
	private Boolean scoring;

	private Boolean signals;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of scoring
	 * @return A Boolean representing the scoring
	 */
	public Boolean getScoring()
	{
		return  this.scoring;

	}

	/**
	 * The method to set the value to scoring
	 * @param scoring A Boolean representing the scoring
	 */
	public void setScoring(Boolean scoring)
	{
		 this.scoring = scoring;

		 this.keyModified.put("scoring", 1);

	}

	/**
	 * The method to get the value of signals
	 * @return A Boolean representing the signals
	 */
	public Boolean getSignals()
	{
		return  this.signals;

	}

	/**
	 * The method to set the value to signals
	 * @param signals A Boolean representing the signals
	 */
	public void setSignals(Boolean signals)
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