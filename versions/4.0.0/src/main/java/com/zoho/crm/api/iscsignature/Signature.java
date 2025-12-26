package com.zoho.crm.api.iscsignature;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Signature implements Model
{
	private Object iscSignature;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of iscSignature
	 * @return An instance of Object
	 */
	public Object getIscSignature()
	{
		return  this.iscSignature;

	}

	/**
	 * The method to set the value to iscSignature
	 * @param iscSignature An instance of Object
	 */
	public void setIscSignature(Object iscSignature)
	{
		 this.iscSignature = iscSignature;

		 this.keyModified.put("isc_signature", 1);

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