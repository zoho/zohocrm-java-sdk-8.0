package com.zoho.crm.api.pipeline;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class Maps implements Model
{
	private String displayValue;

	private Integer sequenceNumber;

	private ForecastCategory forecastCategory;

	private Boolean delete;

	private String actualValue;

	private Long id;

	private String colourCode;

	private String forecastType;

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
	 * The method to get the value of sequenceNumber
	 * @return An Integer representing the sequenceNumber
	 */
	public Integer getSequenceNumber()
	{
		return  this.sequenceNumber;

	}

	/**
	 * The method to set the value to sequenceNumber
	 * @param sequenceNumber An Integer representing the sequenceNumber
	 */
	public void setSequenceNumber(Integer sequenceNumber)
	{
		 this.sequenceNumber = sequenceNumber;

		 this.keyModified.put("sequence_number", 1);

	}

	/**
	 * The method to get the value of forecastCategory
	 * @return An instance of ForecastCategory
	 */
	public ForecastCategory getForecastCategory()
	{
		return  this.forecastCategory;

	}

	/**
	 * The method to set the value to forecastCategory
	 * @param forecastCategory An instance of ForecastCategory
	 */
	public void setForecastCategory(ForecastCategory forecastCategory)
	{
		 this.forecastCategory = forecastCategory;

		 this.keyModified.put("forecast_category", 1);

	}

	/**
	 * The method to get the value of delete
	 * @return A Boolean representing the delete
	 */
	public Boolean getDelete()
	{
		return  this.delete;

	}

	/**
	 * The method to set the value to delete
	 * @param delete A Boolean representing the delete
	 */
	public void setDelete(Boolean delete)
	{
		 this.delete = delete;

		 this.keyModified.put("_delete", 1);

	}

	/**
	 * The method to get the value of actualValue
	 * @return A String representing the actualValue
	 */
	public String getActualValue()
	{
		return  this.actualValue;

	}

	/**
	 * The method to set the value to actualValue
	 * @param actualValue A String representing the actualValue
	 */
	public void setActualValue(String actualValue)
	{
		 this.actualValue = actualValue;

		 this.keyModified.put("actual_value", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A Long representing the id
	 */
	public Long getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A Long representing the id
	 */
	public void setId(Long id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of colourCode
	 * @return A String representing the colourCode
	 */
	public String getColourCode()
	{
		return  this.colourCode;

	}

	/**
	 * The method to set the value to colourCode
	 * @param colourCode A String representing the colourCode
	 */
	public void setColourCode(String colourCode)
	{
		 this.colourCode = colourCode;

		 this.keyModified.put("colour_code", 1);

	}

	/**
	 * The method to get the value of forecastType
	 * @return A String representing the forecastType
	 */
	public String getForecastType()
	{
		return  this.forecastType;

	}

	/**
	 * The method to set the value to forecastType
	 * @param forecastType A String representing the forecastType
	 */
	public void setForecastType(String forecastType)
	{
		 this.forecastType = forecastType;

		 this.keyModified.put("forecast_type", 1);

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