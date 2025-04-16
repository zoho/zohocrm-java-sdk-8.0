package com.zoho.crm.api.fields;

import com.zoho.crm.api.globalpicklists.Picklist;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class PickListValue implements Model
{
	private String colourCode;

	private String actualValue;

	private Choice<String> type;

	private Long id;

	private Integer sequenceNumber;

	private String displayValue;

	private String referenceValue;

	private String dealCategory;

	private Integer probability;

	private ForecastCategory forecastCategory;

	private String expectedDataType;

	private String sysRefName;

	private String forecastType;

	private List<Maps> maps;

	private Boolean delete;

	private Boolean showValue;

	private Picklist globalPicklistValue;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of type
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type An instance of Choice<String>
	 */
	public void setType(Choice<String> type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

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
	 * The method to get the value of referenceValue
	 * @return A String representing the referenceValue
	 */
	public String getReferenceValue()
	{
		return  this.referenceValue;

	}

	/**
	 * The method to set the value to referenceValue
	 * @param referenceValue A String representing the referenceValue
	 */
	public void setReferenceValue(String referenceValue)
	{
		 this.referenceValue = referenceValue;

		 this.keyModified.put("reference_value", 1);

	}

	/**
	 * The method to get the value of dealCategory
	 * @return A String representing the dealCategory
	 */
	public String getDealCategory()
	{
		return  this.dealCategory;

	}

	/**
	 * The method to set the value to dealCategory
	 * @param dealCategory A String representing the dealCategory
	 */
	public void setDealCategory(String dealCategory)
	{
		 this.dealCategory = dealCategory;

		 this.keyModified.put("deal_category", 1);

	}

	/**
	 * The method to get the value of probability
	 * @return An Integer representing the probability
	 */
	public Integer getProbability()
	{
		return  this.probability;

	}

	/**
	 * The method to set the value to probability
	 * @param probability An Integer representing the probability
	 */
	public void setProbability(Integer probability)
	{
		 this.probability = probability;

		 this.keyModified.put("probability", 1);

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
	 * The method to get the value of expectedDataType
	 * @return A String representing the expectedDataType
	 */
	public String getExpectedDataType()
	{
		return  this.expectedDataType;

	}

	/**
	 * The method to set the value to expectedDataType
	 * @param expectedDataType A String representing the expectedDataType
	 */
	public void setExpectedDataType(String expectedDataType)
	{
		 this.expectedDataType = expectedDataType;

		 this.keyModified.put("expected_data_type", 1);

	}

	/**
	 * The method to get the value of sysRefName
	 * @return A String representing the sysRefName
	 */
	public String getSysRefName()
	{
		return  this.sysRefName;

	}

	/**
	 * The method to set the value to sysRefName
	 * @param sysRefName A String representing the sysRefName
	 */
	public void setSysRefName(String sysRefName)
	{
		 this.sysRefName = sysRefName;

		 this.keyModified.put("sys_ref_name", 1);

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
	 * The method to get the value of maps
	 * @return An instance of List<Maps>
	 */
	public List<Maps> getMaps()
	{
		return  this.maps;

	}

	/**
	 * The method to set the value to maps
	 * @param maps An instance of List<Maps>
	 */
	public void setMaps(List<Maps> maps)
	{
		 this.maps = maps;

		 this.keyModified.put("maps", 1);

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
	 * The method to get the value of showValue
	 * @return A Boolean representing the showValue
	 */
	public Boolean getShowValue()
	{
		return  this.showValue;

	}

	/**
	 * The method to set the value to showValue
	 * @param showValue A Boolean representing the showValue
	 */
	public void setShowValue(Boolean showValue)
	{
		 this.showValue = showValue;

		 this.keyModified.put("show_value", 1);

	}

	/**
	 * The method to get the value of globalPicklistValue
	 * @return An instance of Picklist
	 */
	public Picklist getGlobalPicklistValue()
	{
		return  this.globalPicklistValue;

	}

	/**
	 * The method to set the value to globalPicklistValue
	 * @param globalPicklistValue An instance of Picklist
	 */
	public void setGlobalPicklistValue(Picklist globalPicklistValue)
	{
		 this.globalPicklistValue = globalPicklistValue;

		 this.keyModified.put("_global_picklist_value", 1);

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