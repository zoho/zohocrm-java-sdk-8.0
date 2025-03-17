package com.zoho.crm.api.relatedlists;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.util.HashMap;
import java.util.List;

public class RelatedList implements Model
{
	private Long id;

	private String sequenceNumber;

	private String displayLabel;

	private String apiName;

	private ModuleMap module;

	private String name;

	private String action;

	private String href;

	private String type;

	private String connectedmodule;

	private String linkingmodule;

	private Boolean visible;

	private Boolean customizeSort;

	private Boolean customizeFields;

	private Boolean customizeDisplayLabel;

	private Field sortBy;

	private String sortOrder;

	private List<Field> fields;

	private Choice<String> status;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * @return A String representing the sequenceNumber
	 */
	public String getSequenceNumber()
	{
		return  this.sequenceNumber;

	}

	/**
	 * The method to set the value to sequenceNumber
	 * @param sequenceNumber A String representing the sequenceNumber
	 */
	public void setSequenceNumber(String sequenceNumber)
	{
		 this.sequenceNumber = sequenceNumber;

		 this.keyModified.put("sequence_number", 1);

	}

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
	 * The method to get the value of module
	 * @return An instance of ModuleMap
	 */
	public ModuleMap getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of ModuleMap
	 */
	public void setModule(ModuleMap module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

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
	 * The method to get the value of action
	 * @return A String representing the action
	 */
	public String getAction()
	{
		return  this.action;

	}

	/**
	 * The method to set the value to action
	 * @param action A String representing the action
	 */
	public void setAction(String action)
	{
		 this.action = action;

		 this.keyModified.put("action", 1);

	}

	/**
	 * The method to get the value of href
	 * @return A String representing the href
	 */
	public String getHref()
	{
		return  this.href;

	}

	/**
	 * The method to set the value to href
	 * @param href A String representing the href
	 */
	public void setHref(String href)
	{
		 this.href = href;

		 this.keyModified.put("href", 1);

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
	 * The method to get the value of connectedmodule
	 * @return A String representing the connectedmodule
	 */
	public String getConnectedmodule()
	{
		return  this.connectedmodule;

	}

	/**
	 * The method to set the value to connectedmodule
	 * @param connectedmodule A String representing the connectedmodule
	 */
	public void setConnectedmodule(String connectedmodule)
	{
		 this.connectedmodule = connectedmodule;

		 this.keyModified.put("connectedmodule", 1);

	}

	/**
	 * The method to get the value of linkingmodule
	 * @return A String representing the linkingmodule
	 */
	public String getLinkingmodule()
	{
		return  this.linkingmodule;

	}

	/**
	 * The method to set the value to linkingmodule
	 * @param linkingmodule A String representing the linkingmodule
	 */
	public void setLinkingmodule(String linkingmodule)
	{
		 this.linkingmodule = linkingmodule;

		 this.keyModified.put("linkingmodule", 1);

	}

	/**
	 * The method to get the value of visible
	 * @return A Boolean representing the visible
	 */
	public Boolean getVisible()
	{
		return  this.visible;

	}

	/**
	 * The method to set the value to visible
	 * @param visible A Boolean representing the visible
	 */
	public void setVisible(Boolean visible)
	{
		 this.visible = visible;

		 this.keyModified.put("visible", 1);

	}

	/**
	 * The method to get the value of customizeSort
	 * @return A Boolean representing the customizeSort
	 */
	public Boolean getCustomizeSort()
	{
		return  this.customizeSort;

	}

	/**
	 * The method to set the value to customizeSort
	 * @param customizeSort A Boolean representing the customizeSort
	 */
	public void setCustomizeSort(Boolean customizeSort)
	{
		 this.customizeSort = customizeSort;

		 this.keyModified.put("customize_sort", 1);

	}

	/**
	 * The method to get the value of customizeFields
	 * @return A Boolean representing the customizeFields
	 */
	public Boolean getCustomizeFields()
	{
		return  this.customizeFields;

	}

	/**
	 * The method to set the value to customizeFields
	 * @param customizeFields A Boolean representing the customizeFields
	 */
	public void setCustomizeFields(Boolean customizeFields)
	{
		 this.customizeFields = customizeFields;

		 this.keyModified.put("customize_fields", 1);

	}

	/**
	 * The method to get the value of customizeDisplayLabel
	 * @return A Boolean representing the customizeDisplayLabel
	 */
	public Boolean getCustomizeDisplayLabel()
	{
		return  this.customizeDisplayLabel;

	}

	/**
	 * The method to set the value to customizeDisplayLabel
	 * @param customizeDisplayLabel A Boolean representing the customizeDisplayLabel
	 */
	public void setCustomizeDisplayLabel(Boolean customizeDisplayLabel)
	{
		 this.customizeDisplayLabel = customizeDisplayLabel;

		 this.keyModified.put("customize_display_label", 1);

	}

	/**
	 * The method to get the value of sortBy
	 * @return An instance of Field
	 */
	public Field getSortBy()
	{
		return  this.sortBy;

	}

	/**
	 * The method to set the value to sortBy
	 * @param sortBy An instance of Field
	 */
	public void setSortBy(Field sortBy)
	{
		 this.sortBy = sortBy;

		 this.keyModified.put("sort_by", 1);

	}

	/**
	 * The method to get the value of sortOrder
	 * @return A String representing the sortOrder
	 */
	public String getSortOrder()
	{
		return  this.sortOrder;

	}

	/**
	 * The method to set the value to sortOrder
	 * @param sortOrder A String representing the sortOrder
	 */
	public void setSortOrder(String sortOrder)
	{
		 this.sortOrder = sortOrder;

		 this.keyModified.put("sort_order", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of List<Field>
	 */
	public List<Field> getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of List<Field>
	 */
	public void setFields(List<Field> fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of status
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getStatus()
	{
		return  this.status;

	}

	/**
	 * The method to set the value to status
	 * @param status An instance of Choice<String>
	 */
	public void setStatus(Choice<String> status)
	{
		 this.status = status;

		 this.keyModified.put("status", 1);

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