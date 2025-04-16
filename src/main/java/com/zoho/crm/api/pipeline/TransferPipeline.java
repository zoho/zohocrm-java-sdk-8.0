package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class TransferPipeline implements Model
{
	private TPipeline pipeline;

	private List<Stages> stages;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of pipeline
	 * @return An instance of TPipeline
	 */
	public TPipeline getPipeline()
	{
		return  this.pipeline;

	}

	/**
	 * The method to set the value to pipeline
	 * @param pipeline An instance of TPipeline
	 */
	public void setPipeline(TPipeline pipeline)
	{
		 this.pipeline = pipeline;

		 this.keyModified.put("pipeline", 1);

	}

	/**
	 * The method to get the value of stages
	 * @return An instance of List<Stages>
	 */
	public List<Stages> getStages()
	{
		return  this.stages;

	}

	/**
	 * The method to set the value to stages
	 * @param stages An instance of List<Stages>
	 */
	public void setStages(List<Stages> stages)
	{
		 this.stages = stages;

		 this.keyModified.put("stages", 1);

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