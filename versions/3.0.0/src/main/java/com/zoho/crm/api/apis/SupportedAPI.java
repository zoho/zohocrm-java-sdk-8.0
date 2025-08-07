package com.zoho.crm.api.apis;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class SupportedAPI implements Model
{
	private String path;

	private List<OperationTypes> operationTypes;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of path
	 * @return A String representing the path
	 */
	public String getPath()
	{
		return  this.path;

	}

	/**
	 * The method to set the value to path
	 * @param path A String representing the path
	 */
	public void setPath(String path)
	{
		 this.path = path;

		 this.keyModified.put("path", 1);

	}

	/**
	 * The method to get the value of operationTypes
	 * @return An instance of List<OperationTypes>
	 */
	public List<OperationTypes> getOperationTypes()
	{
		return  this.operationTypes;

	}

	/**
	 * The method to set the value to operationTypes
	 * @param operationTypes An instance of List<OperationTypes>
	 */
	public void setOperationTypes(List<OperationTypes> operationTypes)
	{
		 this.operationTypes = operationTypes;

		 this.keyModified.put("operation_types", 1);

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