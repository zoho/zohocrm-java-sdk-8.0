package com.zoho.crm.api.apis;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class OperationTypes implements Model
{
	private String method;

	private String oauthScope;

	private Integer maxCredits;

	private Integer minCredits;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of method
	 * @return A String representing the method
	 */
	public String getMethod()
	{
		return  this.method;

	}

	/**
	 * The method to set the value to method
	 * @param method A String representing the method
	 */
	public void setMethod(String method)
	{
		 this.method = method;

		 this.keyModified.put("method", 1);

	}

	/**
	 * The method to get the value of oauthScope
	 * @return A String representing the oauthScope
	 */
	public String getOauthScope()
	{
		return  this.oauthScope;

	}

	/**
	 * The method to set the value to oauthScope
	 * @param oauthScope A String representing the oauthScope
	 */
	public void setOauthScope(String oauthScope)
	{
		 this.oauthScope = oauthScope;

		 this.keyModified.put("oauth_scope", 1);

	}

	/**
	 * The method to get the value of maxCredits
	 * @return An Integer representing the maxCredits
	 */
	public Integer getMaxCredits()
	{
		return  this.maxCredits;

	}

	/**
	 * The method to set the value to maxCredits
	 * @param maxCredits An Integer representing the maxCredits
	 */
	public void setMaxCredits(Integer maxCredits)
	{
		 this.maxCredits = maxCredits;

		 this.keyModified.put("max_credits", 1);

	}

	/**
	 * The method to get the value of minCredits
	 * @return An Integer representing the minCredits
	 */
	public Integer getMinCredits()
	{
		return  this.minCredits;

	}

	/**
	 * The method to set the value to minCredits
	 * @param minCredits An Integer representing the minCredits
	 */
	public void setMinCredits(Integer minCredits)
	{
		 this.minCredits = minCredits;

		 this.keyModified.put("min_credits", 1);

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