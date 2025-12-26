package com.zoho.crm.api.emailcomposemeta;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Signature implements Model
{
	private Integer mode;

	private String sign;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of mode
	 * @return An Integer representing the mode
	 */
	public Integer getMode()
	{
		return  this.mode;

	}

	/**
	 * The method to set the value to mode
	 * @param mode An Integer representing the mode
	 */
	public void setMode(Integer mode)
	{
		 this.mode = mode;

		 this.keyModified.put("mode", 1);

	}

	/**
	 * The method to get the value of sign
	 * @return A String representing the sign
	 */
	public String getSign()
	{
		return  this.sign;

	}

	/**
	 * The method to set the value to sign
	 * @param sign A String representing the sign
	 */
	public void setSign(String sign)
	{
		 this.sign = sign;

		 this.keyModified.put("sign", 1);

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