package com.zoho.crm.api.timelines;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class FieldHistory implements Model
{
	private String dataType;

	private Boolean enableColourCode;

	private List<PicklistDetail> pickListValues;

	private String fieldLabel;

	private String apiName;

	private Long id;

	private FieldHistoryValue value;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of dataType
	 * @return A String representing the dataType
	 */
	public String getDataType()
	{
		return  this.dataType;

	}

	/**
	 * The method to set the value to dataType
	 * @param dataType A String representing the dataType
	 */
	public void setDataType(String dataType)
	{
		 this.dataType = dataType;

		 this.keyModified.put("data_type", 1);

	}

	/**
	 * The method to get the value of enableColourCode
	 * @return A Boolean representing the enableColourCode
	 */
	public Boolean getEnableColourCode()
	{
		return  this.enableColourCode;

	}

	/**
	 * The method to set the value to enableColourCode
	 * @param enableColourCode A Boolean representing the enableColourCode
	 */
	public void setEnableColourCode(Boolean enableColourCode)
	{
		 this.enableColourCode = enableColourCode;

		 this.keyModified.put("enable_colour_code", 1);

	}

	/**
	 * The method to get the value of pickListValues
	 * @return An instance of List<PicklistDetail>
	 */
	public List<PicklistDetail> getPickListValues()
	{
		return  this.pickListValues;

	}

	/**
	 * The method to set the value to pickListValues
	 * @param pickListValues An instance of List<PicklistDetail>
	 */
	public void setPickListValues(List<PicklistDetail> pickListValues)
	{
		 this.pickListValues = pickListValues;

		 this.keyModified.put("pick_list_values", 1);

	}

	/**
	 * The method to get the value of fieldLabel
	 * @return A String representing the fieldLabel
	 */
	public String getFieldLabel()
	{
		return  this.fieldLabel;

	}

	/**
	 * The method to set the value to fieldLabel
	 * @param fieldLabel A String representing the fieldLabel
	 */
	public void setFieldLabel(String fieldLabel)
	{
		 this.fieldLabel = fieldLabel;

		 this.keyModified.put("field_label", 1);

	}

	/**
	 * The method to get the value of apiName
	 * @return A String representing the apiName
	 */
	public String getAPIName()
	{
		return  this.apiName;

	}

	/**
	 * The method to set the value to apiName
	 * @param apiName A String representing the apiName
	 */
	public void setAPIName(String apiName)
	{
		 this.apiName = apiName;

		 this.keyModified.put("api_name", 1);

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
	 * The method to get the value of value
	 * @return An instance of FieldHistoryValue
	 */
	public FieldHistoryValue getValue()
	{
		return  this.value;

	}

	/**
	 * The method to set the value to value
	 * @param value An instance of FieldHistoryValue
	 */
	public void setValue(FieldHistoryValue value)
	{
		 this.value = value;

		 this.keyModified.put("_value", 1);

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