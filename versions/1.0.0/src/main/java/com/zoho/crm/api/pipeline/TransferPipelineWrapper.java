package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class TransferPipelineWrapper implements Model
{
	private List<TransferPipeline> transferPipeline;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of transferPipeline
	 * @return An instance of List<TransferPipeline>
	 */
	public List<TransferPipeline> getTransferPipeline()
	{
		return  this.transferPipeline;

	}

	/**
	 * The method to set the value to transferPipeline
	 * @param transferPipeline An instance of List<TransferPipeline>
	 */
	public void setTransferPipeline(List<TransferPipeline> transferPipeline)
	{
		 this.transferPipeline = transferPipeline;

		 this.keyModified.put("transfer_pipeline", 1);

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