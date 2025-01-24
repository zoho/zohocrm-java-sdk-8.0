package com.zoho.crm.api.layouts;

import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class Sections implements Model
{
	private String displayLabel;

	private Integer sequenceNumber;

	private Boolean issubformsection;

	private String tabTraversal;

	private String apiName;

	private Integer columnCount;

	private String name;

	private String generatedType;

	private Long id;

	private String type;

	private List<SectionField> fields;

	private Properties properties;

	private Delete1 delete;

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
	 * The method to get the value of issubformsection
	 * @return A Boolean representing the issubformsection
	 */
	public Boolean getIssubformsection()
	{
		return  this.issubformsection;

	}

	/**
	 * The method to set the value to issubformsection
	 * @param issubformsection A Boolean representing the issubformsection
	 */
	public void setIssubformsection(Boolean issubformsection)
	{
		 this.issubformsection = issubformsection;

		 this.keyModified.put("isSubformSection", 1);

	}

	/**
	 * The method to get the value of tabTraversal
	 * @return A String representing the tabTraversal
	 */
	public String getTabTraversal()
	{
		return  this.tabTraversal;

	}

	/**
	 * The method to set the value to tabTraversal
	 * @param tabTraversal A String representing the tabTraversal
	 */
	public void setTabTraversal(String tabTraversal)
	{
		 this.tabTraversal = tabTraversal;

		 this.keyModified.put("tab_traversal", 1);

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
	 * The method to get the value of columnCount
	 * @return An Integer representing the columnCount
	 */
	public Integer getColumnCount()
	{
		return  this.columnCount;

	}

	/**
	 * The method to set the value to columnCount
	 * @param columnCount An Integer representing the columnCount
	 */
	public void setColumnCount(Integer columnCount)
	{
		 this.columnCount = columnCount;

		 this.keyModified.put("column_count", 1);

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
	 * The method to get the value of generatedType
	 * @return A String representing the generatedType
	 */
	public String getGeneratedType()
	{
		return  this.generatedType;

	}

	/**
	 * The method to set the value to generatedType
	 * @param generatedType A String representing the generatedType
	 */
	public void setGeneratedType(String generatedType)
	{
		 this.generatedType = generatedType;

		 this.keyModified.put("generated_type", 1);

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
	 * The method to get the value of type
	 * @return A String representing the type
	 */
	public String getType()
	{
		return  this.type;

	}

	/**
	 * The method to set the value to type
	 * @param type A String representing the type
	 */
	public void setType(String type)
	{
		 this.type = type;

		 this.keyModified.put("type", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of List<SectionField>
	 */
	public List<SectionField> getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of List<SectionField>
	 */
	public void setFields(List<SectionField> fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of properties
	 * @return An instance of Properties
	 */
	public Properties getProperties()
	{
		return  this.properties;

	}

	/**
	 * The method to set the value to properties
	 * @param properties An instance of Properties
	 */
	public void setProperties(Properties properties)
	{
		 this.properties = properties;

		 this.keyModified.put("properties", 1);

	}

	/**
	 * The method to get the value of delete
	 * @return An instance of Delete1
	 */
	public Delete1 getDelete()
	{
		return  this.delete;

	}

	/**
	 * The method to set the value to delete
	 * @param delete An instance of Delete1
	 */
	public void setDelete(Delete1 delete)
	{
		 this.delete = delete;

		 this.keyModified.put("_delete", 1);

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