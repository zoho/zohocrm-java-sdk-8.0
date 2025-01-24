package com.zoho.crm.api.ziapeopleenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Address implements Model
{
	private String continent;

	private String country;

	private String name;

	private String region;

	private Boolean primary;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of continent
	 * @return A String representing the continent
	 */
	public String getContinent()
	{
		return  this.continent;

	}

	/**
	 * The method to set the value to continent
	 * @param continent A String representing the continent
	 */
	public void setContinent(String continent)
	{
		 this.continent = continent;

		 this.keyModified.put("continent", 1);

	}

	/**
	 * The method to get the value of country
	 * @return A String representing the country
	 */
	public String getCountry()
	{
		return  this.country;

	}

	/**
	 * The method to set the value to country
	 * @param country A String representing the country
	 */
	public void setCountry(String country)
	{
		 this.country = country;

		 this.keyModified.put("country", 1);

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
	 * The method to get the value of region
	 * @return A String representing the region
	 */
	public String getRegion()
	{
		return  this.region;

	}

	/**
	 * The method to set the value to region
	 * @param region A String representing the region
	 */
	public void setRegion(String region)
	{
		 this.region = region;

		 this.keyModified.put("region", 1);

	}

	/**
	 * The method to get the value of primary
	 * @return A Boolean representing the primary
	 */
	public Boolean getPrimary()
	{
		return  this.primary;

	}

	/**
	 * The method to set the value to primary
	 * @param primary A Boolean representing the primary
	 */
	public void setPrimary(Boolean primary)
	{
		 this.primary = primary;

		 this.keyModified.put("primary", 1);

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