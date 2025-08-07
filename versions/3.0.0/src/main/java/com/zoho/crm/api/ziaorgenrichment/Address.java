package com.zoho.crm.api.ziaorgenrichment;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Address implements Model
{
	private String country;

	private String city;

	private String pinCode;

	private String state;

	private String fillAddress;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of city
	 * @return A String representing the city
	 */
	public String getCity()
	{
		return  this.city;

	}

	/**
	 * The method to set the value to city
	 * @param city A String representing the city
	 */
	public void setCity(String city)
	{
		 this.city = city;

		 this.keyModified.put("city", 1);

	}

	/**
	 * The method to get the value of pinCode
	 * @return A String representing the pinCode
	 */
	public String getPinCode()
	{
		return  this.pinCode;

	}

	/**
	 * The method to set the value to pinCode
	 * @param pinCode A String representing the pinCode
	 */
	public void setPinCode(String pinCode)
	{
		 this.pinCode = pinCode;

		 this.keyModified.put("pin_code", 1);

	}

	/**
	 * The method to get the value of state
	 * @return A String representing the state
	 */
	public String getState()
	{
		return  this.state;

	}

	/**
	 * The method to set the value to state
	 * @param state A String representing the state
	 */
	public void setState(String state)
	{
		 this.state = state;

		 this.keyModified.put("state", 1);

	}

	/**
	 * The method to get the value of fillAddress
	 * @return A String representing the fillAddress
	 */
	public String getFillAddress()
	{
		return  this.fillAddress;

	}

	/**
	 * The method to set the value to fillAddress
	 * @param fillAddress A String representing the fillAddress
	 */
	public void setFillAddress(String fillAddress)
	{
		 this.fillAddress = fillAddress;

		 this.keyModified.put("fill_address", 1);

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