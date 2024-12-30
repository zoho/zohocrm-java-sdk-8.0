package com.zoho.crm.api.conversionoption;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ResponseWrapper implements Model, ResponseHandler
{
	private ConversionOptions conversionOptions;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of conversionOptions
	 * @return An instance of ConversionOptions
	 */
	public ConversionOptions getConversionOptions()
	{
		return  this.conversionOptions;

	}

	/**
	 * The method to set the value to conversionOptions
	 * @param conversionOptions An instance of ConversionOptions
	 */
	public void setConversionOptions(ConversionOptions conversionOptions)
	{
		 this.conversionOptions = conversionOptions;

		 this.keyModified.put("__conversion_options", 1);

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