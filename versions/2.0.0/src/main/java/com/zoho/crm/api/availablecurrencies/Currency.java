package com.zoho.crm.api.availablecurrencies;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Currency implements Model
{
	private String displayValue;

	private String decimalSeparator;

	private String symbol;

	private String thousandSeparator;

	private String displayName;

	private String isoCode;

	private String decimalPlaces;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of displayValue
	 * @return A String representing the displayValue
	 */
	public String getDisplayValue()
	{
		return  this.displayValue;

	}

	/**
	 * The method to set the value to displayValue
	 * @param displayValue A String representing the displayValue
	 */
	public void setDisplayValue(String displayValue)
	{
		 this.displayValue = displayValue;

		 this.keyModified.put("display_value", 1);

	}

	/**
	 * The method to get the value of decimalSeparator
	 * @return A String representing the decimalSeparator
	 */
	public String getDecimalSeparator()
	{
		return  this.decimalSeparator;

	}

	/**
	 * The method to set the value to decimalSeparator
	 * @param decimalSeparator A String representing the decimalSeparator
	 */
	public void setDecimalSeparator(String decimalSeparator)
	{
		 this.decimalSeparator = decimalSeparator;

		 this.keyModified.put("decimal_separator", 1);

	}

	/**
	 * The method to get the value of symbol
	 * @return A String representing the symbol
	 */
	public String getSymbol()
	{
		return  this.symbol;

	}

	/**
	 * The method to set the value to symbol
	 * @param symbol A String representing the symbol
	 */
	public void setSymbol(String symbol)
	{
		 this.symbol = symbol;

		 this.keyModified.put("symbol", 1);

	}

	/**
	 * The method to get the value of thousandSeparator
	 * @return A String representing the thousandSeparator
	 */
	public String getThousandSeparator()
	{
		return  this.thousandSeparator;

	}

	/**
	 * The method to set the value to thousandSeparator
	 * @param thousandSeparator A String representing the thousandSeparator
	 */
	public void setThousandSeparator(String thousandSeparator)
	{
		 this.thousandSeparator = thousandSeparator;

		 this.keyModified.put("thousand_separator", 1);

	}

	/**
	 * The method to get the value of displayName
	 * @return A String representing the displayName
	 */
	public String getDisplayName()
	{
		return  this.displayName;

	}

	/**
	 * The method to set the value to displayName
	 * @param displayName A String representing the displayName
	 */
	public void setDisplayName(String displayName)
	{
		 this.displayName = displayName;

		 this.keyModified.put("display_name", 1);

	}

	/**
	 * The method to get the value of isoCode
	 * @return A String representing the isoCode
	 */
	public String getIsoCode()
	{
		return  this.isoCode;

	}

	/**
	 * The method to set the value to isoCode
	 * @param isoCode A String representing the isoCode
	 */
	public void setIsoCode(String isoCode)
	{
		 this.isoCode = isoCode;

		 this.keyModified.put("iso_code", 1);

	}

	/**
	 * The method to get the value of decimalPlaces
	 * @return A String representing the decimalPlaces
	 */
	public String getDecimalPlaces()
	{
		return  this.decimalPlaces;

	}

	/**
	 * The method to set the value to decimalPlaces
	 * @param decimalPlaces A String representing the decimalPlaces
	 */
	public void setDecimalPlaces(String decimalPlaces)
	{
		 this.decimalPlaces = decimalPlaces;

		 this.keyModified.put("decimal_places", 1);

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