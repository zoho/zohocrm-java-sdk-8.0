package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class BodyWrapper implements Model
{
	private List<Pipeline> pipeline;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of pipeline
	 * @return An instance of List<Pipeline>
	 */
	public List<Pipeline> getPipeline()
	{
		return  this.pipeline;

	}

	/**
	 * The method to set the value to pipeline
	 * @param pipeline An instance of List<Pipeline>
	 */
	public void setPipeline(List<Pipeline> pipeline)
	{
		 this.pipeline = pipeline;

		 this.keyModified.put("pipeline", 1);

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