package com.zoho.crm.api.scoringrules;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class SignalRule implements Model
{
	private Integer score;

	private Signal signal;

	private String id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of score
	 * @return An Integer representing the score
	 */
	public Integer getScore()
	{
		return  this.score;

	}

	/**
	 * The method to set the value to score
	 * @param score An Integer representing the score
	 */
	public void setScore(Integer score)
	{
		 this.score = score;

		 this.keyModified.put("score", 1);

	}

	/**
	 * The method to get the value of signal
	 * @return An instance of Signal
	 */
	public Signal getSignal()
	{
		return  this.signal;

	}

	/**
	 * The method to set the value to signal
	 * @param signal An instance of Signal
	 */
	public void setSignal(Signal signal)
	{
		 this.signal = signal;

		 this.keyModified.put("signal", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

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