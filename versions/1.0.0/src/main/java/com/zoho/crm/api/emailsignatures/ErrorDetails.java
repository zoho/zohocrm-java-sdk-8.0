package com.zoho.crm.api.emailsignatures;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class ErrorDetails implements Model
{
	private String apiName;

	private String jsonPath;

	private List<Object> supportedValues;

	private RangeStructure range;

	private String paramName;

	private String regex;

	private String expectedDataType;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

	}

	/**
	 * The method to get the value of jsonPath
	 * @return A String representing the jsonPath
	 */
	public String getJsonPath()
	{
		return  this.jsonPath;

	}

	/**
	 * The method to set the value to jsonPath
	 * @param jsonPath A String representing the jsonPath
	 */
	public void setJsonPath(String jsonPath)
	{
		 this.jsonPath = jsonPath;

		 this.keyModified.put("json_path", 1);

	}

	/**
	 * The method to get the value of supportedValues
	 * @return An instance of List<Object>
	 */
	public List<Object> getSupportedValues()
	{
		return  this.supportedValues;

	}

	/**
	 * The method to set the value to supportedValues
	 * @param supportedValues An instance of List<Object>
	 */
	public void setSupportedValues(List<Object> supportedValues)
	{
		 this.supportedValues = supportedValues;

		 this.keyModified.put("supported_values", 1);

	}

	/**
	 * The method to get the value of range
	 * @return An instance of RangeStructure
	 */
	public RangeStructure getRange()
	{
		return  this.range;

	}

	/**
	 * The method to set the value to range
	 * @param range An instance of RangeStructure
	 */
	public void setRange(RangeStructure range)
	{
		 this.range = range;

		 this.keyModified.put("range", 1);

	}

	/**
	 * The method to get the value of paramName
	 * @return A String representing the paramName
	 */
	public String getParamName()
	{
		return  this.paramName;

	}

	/**
	 * The method to set the value to paramName
	 * @param paramName A String representing the paramName
	 */
	public void setParamName(String paramName)
	{
		 this.paramName = paramName;

		 this.keyModified.put("param_name", 1);

	}

	/**
	 * The method to get the value of regex
	 * @return A String representing the regex
	 */
	public String getRegex()
	{
		return  this.regex;

	}

	/**
	 * The method to set the value to regex
	 * @param regex A String representing the regex
	 */
	public void setRegex(String regex)
	{
		 this.regex = regex;

		 this.keyModified.put("regex", 1);

	}

	/**
	 * The method to get the value of expectedDataType
	 * @return A String representing the expectedDataType
	 */
	public String getExpectedDataType()
	{
		return  this.expectedDataType;

	}

	/**
	 * The method to set the value to expectedDataType
	 * @param expectedDataType A String representing the expectedDataType
	 */
	public void setExpectedDataType(String expectedDataType)
	{
		 this.expectedDataType = expectedDataType;

		 this.keyModified.put("expected_data_type", 1);

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