package com.zoho.crm.api.privacypreference;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Tpt implements Model
{
	private String isenabled;

	private String name;

	private String issupported;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of isenabled
	 * @return A String representing the isenabled
	 */
	public String getIsenabled()
	{
		return  this.isenabled;

	}

	/**
	 * The method to set the value to isenabled
	 * @param isenabled A String representing the isenabled
	 */
	public void setIsenabled(String isenabled)
	{
		 this.isenabled = isenabled;

		 this.keyModified.put("isEnabled", 1);

	}

	/**
	 * The method to get the value of name
	 * @return A String representing the name
	 */
	public String getName()
	{
		return  this.name;

	}

	/**
	 * The method to set the value to name
	 * @param name A String representing the name
	 */
	public void setName(String name)
	{
		 this.name = name;

		 this.keyModified.put("name", 1);

	}

	/**
	 * The method to get the value of issupported
	 * @return A String representing the issupported
	 */
	public String getIssupported()
	{
		return  this.issupported;

	}

	/**
	 * The method to set the value to issupported
	 * @param issupported A String representing the issupported
	 */
	public void setIssupported(String issupported)
	{
		 this.issupported = issupported;

		 this.keyModified.put("isSupported", 1);

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