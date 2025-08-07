package com.zoho.crm.api.globalpicklists;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Picklist implements Model
{
	private String displayLabel;

	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private Long id;

	private String apiName;

	private String actualLabel;

	private String description;

	private MinifiedUser modifiedBy;

	private MinifiedUser createdBy;

	private Boolean presence;

	private Boolean pickListValuesSortedLexically;

	private List<PickListValues> pickListValues;

	private Integer associatedFieldsCount;

	private List<Module> usedInModules;

	private Boolean customizable;

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
	 * The method to get the value of createdTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getCreatedTime()
	{
		return  this.createdTime;

	}

	/**
	 * The method to set the value to createdTime
	 * @param createdTime An instance of OffsetDateTime
	 */
	public void setCreatedTime(OffsetDateTime createdTime)
	{
		 this.createdTime = createdTime;

		 this.keyModified.put("created_time", 1);

	}

	/**
	 * The method to get the value of modifiedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getModifiedTime()
	{
		return  this.modifiedTime;

	}

	/**
	 * The method to set the value to modifiedTime
	 * @param modifiedTime An instance of OffsetDateTime
	 */
	public void setModifiedTime(OffsetDateTime modifiedTime)
	{
		 this.modifiedTime = modifiedTime;

		 this.keyModified.put("modified_time", 1);

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
	 * The method to get the value of actualLabel
	 * @return A String representing the actualLabel
	 */
	public String getActualLabel()
	{
		return  this.actualLabel;

	}

	/**
	 * The method to set the value to actualLabel
	 * @param actualLabel A String representing the actualLabel
	 */
	public void setActualLabel(String actualLabel)
	{
		 this.actualLabel = actualLabel;

		 this.keyModified.put("actual_label", 1);

	}

	/**
	 * The method to get the value of description
	 * @return A String representing the description
	 */
	public String getDescription()
	{
		return  this.description;

	}

	/**
	 * The method to set the value to description
	 * @param description A String representing the description
	 */
	public void setDescription(String description)
	{
		 this.description = description;

		 this.keyModified.put("description", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of MinifiedUser
	 */
	public void setModifiedBy(MinifiedUser modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of createdBy
	 * @return An instance of MinifiedUser
	 */
	public MinifiedUser getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of MinifiedUser
	 */
	public void setCreatedBy(MinifiedUser createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of presence
	 * @return A Boolean representing the presence
	 */
	public Boolean getPresence()
	{
		return  this.presence;

	}

	/**
	 * The method to set the value to presence
	 * @param presence A Boolean representing the presence
	 */
	public void setPresence(Boolean presence)
	{
		 this.presence = presence;

		 this.keyModified.put("presence", 1);

	}

	/**
	 * The method to get the value of pickListValuesSortedLexically
	 * @return A Boolean representing the pickListValuesSortedLexically
	 */
	public Boolean getPickListValuesSortedLexically()
	{
		return  this.pickListValuesSortedLexically;

	}

	/**
	 * The method to set the value to pickListValuesSortedLexically
	 * @param pickListValuesSortedLexically A Boolean representing the pickListValuesSortedLexically
	 */
	public void setPickListValuesSortedLexically(Boolean pickListValuesSortedLexically)
	{
		 this.pickListValuesSortedLexically = pickListValuesSortedLexically;

		 this.keyModified.put("pick_list_values_sorted_lexically", 1);

	}

	/**
	 * The method to get the value of pickListValues
	 * @return An instance of List<PickListValues>
	 */
	public List<PickListValues> getPickListValues()
	{
		return  this.pickListValues;

	}

	/**
	 * The method to set the value to pickListValues
	 * @param pickListValues An instance of List<PickListValues>
	 */
	public void setPickListValues(List<PickListValues> pickListValues)
	{
		 this.pickListValues = pickListValues;

		 this.keyModified.put("pick_list_values", 1);

	}

	/**
	 * The method to get the value of associatedFieldsCount
	 * @return An Integer representing the associatedFieldsCount
	 */
	public Integer getAssociatedFieldsCount()
	{
		return  this.associatedFieldsCount;

	}

	/**
	 * The method to set the value to associatedFieldsCount
	 * @param associatedFieldsCount An Integer representing the associatedFieldsCount
	 */
	public void setAssociatedFieldsCount(Integer associatedFieldsCount)
	{
		 this.associatedFieldsCount = associatedFieldsCount;

		 this.keyModified.put("associated_fields_count", 1);

	}

	/**
	 * The method to get the value of usedInModules
	 * @return An instance of List<Module>
	 */
	public List<Module> getUsedInModules()
	{
		return  this.usedInModules;

	}

	/**
	 * The method to set the value to usedInModules
	 * @param usedInModules An instance of List<Module>
	 */
	public void setUsedInModules(List<Module> usedInModules)
	{
		 this.usedInModules = usedInModules;

		 this.keyModified.put("used_in_modules", 1);

	}

	/**
	 * The method to get the value of customizable
	 * @return A Boolean representing the customizable
	 */
	public Boolean getCustomizable()
	{
		return  this.customizable;

	}

	/**
	 * The method to set the value to customizable
	 * @param customizable A Boolean representing the customizable
	 */
	public void setCustomizable(Boolean customizable)
	{
		 this.customizable = customizable;

		 this.keyModified.put("customizable", 1);

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