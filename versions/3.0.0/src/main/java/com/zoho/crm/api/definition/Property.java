package com.zoho.crm.api.definition;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Property implements Model
{
	private String displayLabel;

	private List<Object> allowedValues;

	private Integer uiType;

	private String regex;

	private Boolean readOnly;

	private String apiName;

	private String fieldLabel;

	private String dataType;

	private Integer length;

	private Boolean availableInUserLayout;

	private Boolean required;

	private List<MinifiedProperty> properties;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of displayLabel
	 * @return A String representing the displayLabel
	 */
	public String getDisplayLabel()
	{
		return  this.displayLabel;

	}

	/**
	 * The method to set the value to displayLabel
	 * @param displayLabel A String representing the displayLabel
	 */
	public void setDisplayLabel(String displayLabel)
	{
		 this.displayLabel = displayLabel;

		 this.keyModified.put("display_label", 1);

	}

	/**
	 * The method to get the value of allowedValues
	 * @return An instance of List<Object>
	 */
	public List<Object> getAllowedValues()
	{
		return  this.allowedValues;

	}

	/**
	 * The method to set the value to allowedValues
	 * @param allowedValues An instance of List<Object>
	 */
	public void setAllowedValues(List<Object> allowedValues)
	{
		 this.allowedValues = allowedValues;

		 this.keyModified.put("allowed_values", 1);

	}

	/**
	 * The method to get the value of uiType
	 * @return An Integer representing the uiType
	 */
	public Integer getUiType()
	{
		return  this.uiType;

	}

	/**
	 * The method to set the value to uiType
	 * @param uiType An Integer representing the uiType
	 */
	public void setUiType(Integer uiType)
	{
		 this.uiType = uiType;

		 this.keyModified.put("ui_type", 1);

	}

	/**
	 * The method to get the value of regex
	 * @return A String representing the regex
	 */
	public String getRegex()
	{
		return  this.regex;

	}

	/**
	 * The method to set the value to regex
	 * @param regex A String representing the regex
	 */
	public void setRegex(String regex)
	{
		 this.regex = regex;

		 this.keyModified.put("regex", 1);

	}

	/**
	 * The method to get the value of readOnly
	 * @return A Boolean representing the readOnly
	 */
	public Boolean getReadOnly()
	{
		return  this.readOnly;

	}

	/**
	 * The method to set the value to readOnly
	 * @param readOnly A Boolean representing the readOnly
	 */
	public void setReadOnly(Boolean readOnly)
	{
		 this.readOnly = readOnly;

		 this.keyModified.put("read_only", 1);

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
	 * The method to get the value of length
	 * @return An Integer representing the length
	 */
	public Integer getLength()
	{
		return  this.length;

	}

	/**
	 * The method to set the value to length
	 * @param length An Integer representing the length
	 */
	public void setLength(Integer length)
	{
		 this.length = length;

		 this.keyModified.put("length", 1);

	}

	/**
	 * The method to get the value of availableInUserLayout
	 * @return A Boolean representing the availableInUserLayout
	 */
	public Boolean getAvailableInUserLayout()
	{
		return  this.availableInUserLayout;

	}

	/**
	 * The method to set the value to availableInUserLayout
	 * @param availableInUserLayout A Boolean representing the availableInUserLayout
	 */
	public void setAvailableInUserLayout(Boolean availableInUserLayout)
	{
		 this.availableInUserLayout = availableInUserLayout;

		 this.keyModified.put("available_in_user_layout", 1);

	}

	/**
	 * The method to get the value of required
	 * @return A Boolean representing the required
	 */
	public Boolean getRequired()
	{
		return  this.required;

	}

	/**
	 * The method to set the value to required
	 * @param required A Boolean representing the required
	 */
	public void setRequired(Boolean required)
	{
		 this.required = required;

		 this.keyModified.put("required", 1);

	}

	/**
	 * The method to get the value of properties
	 * @return An instance of List<MinifiedProperty>
	 */
	public List<MinifiedProperty> getProperties()
	{
		return  this.properties;

	}

	/**
	 * The method to set the value to properties
	 * @param properties An instance of List<MinifiedProperty>
	 */
	public void setProperties(List<MinifiedProperty> properties)
	{
		 this.properties = properties;

		 this.keyModified.put("properties", 1);

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