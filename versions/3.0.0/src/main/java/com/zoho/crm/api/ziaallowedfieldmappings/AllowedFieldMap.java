package com.zoho.crm.api.ziaallowedfieldmappings;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class AllowedFieldMap implements Model
{
	private List<AllowedOutputData> outputDataFieldMapping;

	private List<AllowedOutputData> inputDataFieldMapping;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of outputDataFieldMapping
	 * @return An instance of List<AllowedOutputData>
	 */
	public List<AllowedOutputData> getOutputDataFieldMapping()
	{
		return  this.outputDataFieldMapping;

	}

	/**
	 * The method to set the value to outputDataFieldMapping
	 * @param outputDataFieldMapping An instance of List<AllowedOutputData>
	 */
	public void setOutputDataFieldMapping(List<AllowedOutputData> outputDataFieldMapping)
	{
		 this.outputDataFieldMapping = outputDataFieldMapping;

		 this.keyModified.put("output_data_field_mapping", 1);

	}

	/**
	 * The method to get the value of inputDataFieldMapping
	 * @return An instance of List<AllowedOutputData>
	 */
	public List<AllowedOutputData> getInputDataFieldMapping()
	{
		return  this.inputDataFieldMapping;

	}

	/**
	 * The method to set the value to inputDataFieldMapping
	 * @param inputDataFieldMapping An instance of List<AllowedOutputData>
	 */
	public void setInputDataFieldMapping(List<AllowedOutputData> inputDataFieldMapping)
	{
		 this.inputDataFieldMapping = inputDataFieldMapping;

		 this.keyModified.put("input_data_field_mapping", 1);

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