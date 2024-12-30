package com.zoho.crm.api.blueprint;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;

public class ProcessInfo implements Model
{
	private Long fieldId;

	private Boolean isContinuous;

	private String apiName;

	private Boolean continuous;

	private String fieldLabel;

	private String name;

	private String columnName;

	private String fieldValue;

	private String id;

	private String fieldName;

	private Escalation escalation;

	private CurrentPicklist currentPicklist;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of fieldId
	 * @return A Long representing the fieldId
	 */
	public Long getFieldId()
	{
		return  this.fieldId;

	}

	/**
	 * The method to set the value to fieldId
	 * @param fieldId A Long representing the fieldId
	 */
	public void setFieldId(Long fieldId)
	{
		 this.fieldId = fieldId;

		 this.keyModified.put("field_id", 1);

	}

	/**
	 * The method to get the value of isContinuous
	 * @return A Boolean representing the isContinuous
	 */
	public Boolean getIsContinuous()
	{
		return  this.isContinuous;

	}

	/**
	 * The method to set the value to isContinuous
	 * @param isContinuous A Boolean representing the isContinuous
	 */
	public void setIsContinuous(Boolean isContinuous)
	{
		 this.isContinuous = isContinuous;

		 this.keyModified.put("is_continuous", 1);

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
	 * The method to get the value of continuous
	 * @return A Boolean representing the continuous
	 */
	public Boolean getContinuous()
	{
		return  this.continuous;

	}

	/**
	 * The method to set the value to continuous
	 * @param continuous A Boolean representing the continuous
	 */
	public void setContinuous(Boolean continuous)
	{
		 this.continuous = continuous;

		 this.keyModified.put("continuous", 1);

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
	 * The method to get the value of columnName
	 * @return A String representing the columnName
	 */
	public String getColumnName()
	{
		return  this.columnName;

	}

	/**
	 * The method to set the value to columnName
	 * @param columnName A String representing the columnName
	 */
	public void setColumnName(String columnName)
	{
		 this.columnName = columnName;

		 this.keyModified.put("column_name", 1);

	}

	/**
	 * The method to get the value of fieldValue
	 * @return A String representing the fieldValue
	 */
	public String getFieldValue()
	{
		return  this.fieldValue;

	}

	/**
	 * The method to set the value to fieldValue
	 * @param fieldValue A String representing the fieldValue
	 */
	public void setFieldValue(String fieldValue)
	{
		 this.fieldValue = fieldValue;

		 this.keyModified.put("field_value", 1);

	}

	/**
	 * The method to get the value of id
	 * @return A String representing the id
	 */
	public String getId()
	{
		return  this.id;

	}

	/**
	 * The method to set the value to id
	 * @param id A String representing the id
	 */
	public void setId(String id)
	{
		 this.id = id;

		 this.keyModified.put("id", 1);

	}

	/**
	 * The method to get the value of fieldName
	 * @return A String representing the fieldName
	 */
	public String getFieldName()
	{
		return  this.fieldName;

	}

	/**
	 * The method to set the value to fieldName
	 * @param fieldName A String representing the fieldName
	 */
	public void setFieldName(String fieldName)
	{
		 this.fieldName = fieldName;

		 this.keyModified.put("field_name", 1);

	}

	/**
	 * The method to get the value of escalation
	 * @return An instance of Escalation
	 */
	public Escalation getEscalation()
	{
		return  this.escalation;

	}

	/**
	 * The method to set the value to escalation
	 * @param escalation An instance of Escalation
	 */
	public void setEscalation(Escalation escalation)
	{
		 this.escalation = escalation;

		 this.keyModified.put("escalation", 1);

	}

	/**
	 * The method to get the value of currentPicklist
	 * @return An instance of CurrentPicklist
	 */
	public CurrentPicklist getCurrentPicklist()
	{
		return  this.currentPicklist;

	}

	/**
	 * The method to set the value to currentPicklist
	 * @param currentPicklist An instance of CurrentPicklist
	 */
	public void setCurrentPicklist(CurrentPicklist currentPicklist)
	{
		 this.currentPicklist = currentPicklist;

		 this.keyModified.put("current_picklist", 1);

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