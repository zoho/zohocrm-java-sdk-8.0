package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class DPipeline implements Model
{
	private Delete delete;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of delete
	 * @return An instance of Delete
	 */
	public Delete getDelete()
	{
		return  this.delete;

	}

	/**
	 * The method to set the value to delete
	 * @param delete An instance of Delete
	 */
	public void setDelete(Delete delete)
	{
		 this.delete = delete;

		 this.keyModified.put("_delete", 1);

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