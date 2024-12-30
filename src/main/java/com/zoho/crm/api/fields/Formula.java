package com.zoho.crm.api.fields;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Formula implements Model
{
	private String returnType;

	private Boolean assumeDefault;

	private String expression;

	private Boolean dynamic;

	private Boolean stopComputeConditionally;

	private String stopComputeExpression;

	private String expression2;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of returnType
	 * @return A String representing the returnType
	 */
	public String getReturnType()
	{
		return  this.returnType;

	}

	/**
	 * The method to set the value to returnType
	 * @param returnType A String representing the returnType
	 */
	public void setReturnType(String returnType)
	{
		 this.returnType = returnType;

		 this.keyModified.put("return_type", 1);

	}

	/**
	 * The method to get the value of assumeDefault
	 * @return A Boolean representing the assumeDefault
	 */
	public Boolean getAssumeDefault()
	{
		return  this.assumeDefault;

	}

	/**
	 * The method to set the value to assumeDefault
	 * @param assumeDefault A Boolean representing the assumeDefault
	 */
	public void setAssumeDefault(Boolean assumeDefault)
	{
		 this.assumeDefault = assumeDefault;

		 this.keyModified.put("assume_default", 1);

	}

	/**
	 * The method to get the value of expression
	 * @return A String representing the expression
	 */
	public String getExpression()
	{
		return  this.expression;

	}

	/**
	 * The method to set the value to expression
	 * @param expression A String representing the expression
	 */
	public void setExpression(String expression)
	{
		 this.expression = expression;

		 this.keyModified.put("expression", 1);

	}

	/**
	 * The method to get the value of dynamic
	 * @return A Boolean representing the dynamic
	 */
	public Boolean getDynamic()
	{
		return  this.dynamic;

	}

	/**
	 * The method to set the value to dynamic
	 * @param dynamic A Boolean representing the dynamic
	 */
	public void setDynamic(Boolean dynamic)
	{
		 this.dynamic = dynamic;

		 this.keyModified.put("dynamic", 1);

	}

	/**
	 * The method to get the value of stopComputeConditionally
	 * @return A Boolean representing the stopComputeConditionally
	 */
	public Boolean getStopComputeConditionally()
	{
		return  this.stopComputeConditionally;

	}

	/**
	 * The method to set the value to stopComputeConditionally
	 * @param stopComputeConditionally A Boolean representing the stopComputeConditionally
	 */
	public void setStopComputeConditionally(Boolean stopComputeConditionally)
	{
		 this.stopComputeConditionally = stopComputeConditionally;

		 this.keyModified.put("stop_compute_conditionally", 1);

	}

	/**
	 * The method to get the value of stopComputeExpression
	 * @return A String representing the stopComputeExpression
	 */
	public String getStopComputeExpression()
	{
		return  this.stopComputeExpression;

	}

	/**
	 * The method to set the value to stopComputeExpression
	 * @param stopComputeExpression A String representing the stopComputeExpression
	 */
	public void setStopComputeExpression(String stopComputeExpression)
	{
		 this.stopComputeExpression = stopComputeExpression;

		 this.keyModified.put("stop_compute_expression", 1);

	}

	/**
	 * The method to get the value of expression2
	 * @return A String representing the expression2
	 */
	public String getExpression2()
	{
		return  this.expression2;

	}

	/**
	 * The method to set the value to expression2
	 * @param expression2 A String representing the expression2
	 */
	public void setExpression2(String expression2)
	{
		 this.expression2 = expression2;

		 this.keyModified.put("expression", 1);

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