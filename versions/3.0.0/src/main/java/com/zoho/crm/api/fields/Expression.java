package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Expression implements Model
{
	private List<FunctionParameter> functionParameters;

	private Criteria criteria;

	private String function;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of functionParameters
	 * @return An instance of List<FunctionParameter>
	 */
	public List<FunctionParameter> getFunctionParameters()
	{
		return  this.functionParameters;

	}

	/**
	 * The method to set the value to functionParameters
	 * @param functionParameters An instance of List<FunctionParameter>
	 */
	public void setFunctionParameters(List<FunctionParameter> functionParameters)
	{
		 this.functionParameters = functionParameters;

		 this.keyModified.put("function_parameters", 1);

	}

	/**
	 * The method to get the value of criteria
	 * @return An instance of Criteria
	 */
	public Criteria getCriteria()
	{
		return  this.criteria;

	}

	/**
	 * The method to set the value to criteria
	 * @param criteria An instance of Criteria
	 */
	public void setCriteria(Criteria criteria)
	{
		 this.criteria = criteria;

		 this.keyModified.put("criteria", 1);

	}

	/**
	 * The method to get the value of function
	 * @return A String representing the function
	 */
	public String getFunction()
	{
		return  this.function;

	}

	/**
	 * The method to set the value to function
	 * @param function A String representing the function
	 */
	public void setFunction(String function)
	{
		 this.function = function;

		 this.keyModified.put("function", 1);

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