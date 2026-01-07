package com.zoho.crm.api.customviews;

import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class CustomViews implements Model
{
	private String displayValue;

	private String systemName;

	private String category;

	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private OffsetDateTime lastAccessedTime;

	private String name;

	private Owner createdBy;

	private Owner modifiedBy;

	private Owner module;

	private Criteria criteria;

	private Boolean default1;

	private Boolean systemDefined;

	private Boolean locked;

	private Integer favorite;

	private Boolean offline;

	private Choice<String> accessType;

	private List<SharedTo> sharedTo;

	private List<Fields> fields;

	private SortBy sortBy;

	private Choice<String> sortOrder;

	private Long id;

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
	 * The method to get the value of systemName
	 * @return A String representing the systemName
	 */
	public String getSystemName()
	{
		return  this.systemName;

	}

	/**
	 * The method to set the value to systemName
	 * @param systemName A String representing the systemName
	 */
	public void setSystemName(String systemName)
	{
		 this.systemName = systemName;

		 this.keyModified.put("system_name", 1);

	}

	/**
	 * The method to get the value of category
	 * @return A String representing the category
	 */
	public String getCategory()
	{
		return  this.category;

	}

	/**
	 * The method to set the value to category
	 * @param category A String representing the category
	 */
	public void setCategory(String category)
	{
		 this.category = category;

		 this.keyModified.put("category", 1);

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
	 * The method to get the value of lastAccessedTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getLastAccessedTime()
	{
		return  this.lastAccessedTime;

	}

	/**
	 * The method to set the value to lastAccessedTime
	 * @param lastAccessedTime An instance of OffsetDateTime
	 */
	public void setLastAccessedTime(OffsetDateTime lastAccessedTime)
	{
		 this.lastAccessedTime = lastAccessedTime;

		 this.keyModified.put("last_accessed_time", 1);

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
	 * The method to get the value of createdBy
	 * @return An instance of Owner
	 */
	public Owner getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of Owner
	 */
	public void setCreatedBy(Owner createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of Owner
	 */
	public Owner getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of Owner
	 */
	public void setModifiedBy(Owner modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of module
	 * @return An instance of Owner
	 */
	public Owner getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module An instance of Owner
	 */
	public void setModule(Owner module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

	}

	/**
	 * The method to get the value of criteria
	 * @return An instance of Criteria
	 */
	public Criteria getCriteria()
	{
		return  this.criteria;

	}

	/**
	 * The method to set the value to criteria
	 * @param criteria An instance of Criteria
	 */
	public void setCriteria(Criteria criteria)
	{
		 this.criteria = criteria;

		 this.keyModified.put("criteria", 1);

	}

	/**
	 * The method to get the value of default
	 * @return A Boolean representing the default1
	 */
	public Boolean getDefault()
	{
		return  this.default1;

	}

	/**
	 * The method to set the value to default
	 * @param default1 A Boolean representing the default1
	 */
	public void setDefault(Boolean default1)
	{
		 this.default1 = default1;

		 this.keyModified.put("default", 1);

	}

	/**
	 * The method to get the value of systemDefined
	 * @return A Boolean representing the systemDefined
	 */
	public Boolean getSystemDefined()
	{
		return  this.systemDefined;

	}

	/**
	 * The method to set the value to systemDefined
	 * @param systemDefined A Boolean representing the systemDefined
	 */
	public void setSystemDefined(Boolean systemDefined)
	{
		 this.systemDefined = systemDefined;

		 this.keyModified.put("system_defined", 1);

	}

	/**
	 * The method to get the value of locked
	 * @return A Boolean representing the locked
	 */
	public Boolean getLocked()
	{
		return  this.locked;

	}

	/**
	 * The method to set the value to locked
	 * @param locked A Boolean representing the locked
	 */
	public void setLocked(Boolean locked)
	{
		 this.locked = locked;

		 this.keyModified.put("locked", 1);

	}

	/**
	 * The method to get the value of favorite
	 * @return An Integer representing the favorite
	 */
	public Integer getFavorite()
	{
		return  this.favorite;

	}

	/**
	 * The method to set the value to favorite
	 * @param favorite An Integer representing the favorite
	 */
	public void setFavorite(Integer favorite)
	{
		 this.favorite = favorite;

		 this.keyModified.put("favorite", 1);

	}

	/**
	 * The method to get the value of offline
	 * @return A Boolean representing the offline
	 */
	public Boolean getOffline()
	{
		return  this.offline;

	}

	/**
	 * The method to set the value to offline
	 * @param offline A Boolean representing the offline
	 */
	public void setOffline(Boolean offline)
	{
		 this.offline = offline;

		 this.keyModified.put("offline", 1);

	}

	/**
	 * The method to get the value of accessType
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getAccessType()
	{
		return  this.accessType;

	}

	/**
	 * The method to set the value to accessType
	 * @param accessType An instance of Choice<String>
	 */
	public void setAccessType(Choice<String> accessType)
	{
		 this.accessType = accessType;

		 this.keyModified.put("access_type", 1);

	}

	/**
	 * The method to get the value of sharedTo
	 * @return An instance of List<SharedTo>
	 */
	public List<SharedTo> getSharedTo()
	{
		return  this.sharedTo;

	}

	/**
	 * The method to set the value to sharedTo
	 * @param sharedTo An instance of List<SharedTo>
	 */
	public void setSharedTo(List<SharedTo> sharedTo)
	{
		 this.sharedTo = sharedTo;

		 this.keyModified.put("shared_to", 1);

	}

	/**
	 * The method to get the value of fields
	 * @return An instance of List<Fields>
	 */
	public List<Fields> getFields()
	{
		return  this.fields;

	}

	/**
	 * The method to set the value to fields
	 * @param fields An instance of List<Fields>
	 */
	public void setFields(List<Fields> fields)
	{
		 this.fields = fields;

		 this.keyModified.put("fields", 1);

	}

	/**
	 * The method to get the value of sortBy
	 * @return An instance of SortBy
	 */
	public SortBy getSortBy()
	{
		return  this.sortBy;

	}

	/**
	 * The method to set the value to sortBy
	 * @param sortBy An instance of SortBy
	 */
	public void setSortBy(SortBy sortBy)
	{
		 this.sortBy = sortBy;

		 this.keyModified.put("sort_by", 1);

	}

	/**
	 * The method to get the value of sortOrder
	 * @return An instance of Choice<String>
	 */
	public Choice<String> getSortOrder()
	{
		return  this.sortOrder;

	}

	/**
	 * The method to set the value to sortOrder
	 * @param sortOrder An instance of Choice<String>
	 */
	public void setSortOrder(Choice<String> sortOrder)
	{
		 this.sortOrder = sortOrder;

		 this.keyModified.put("sort_order", 1);

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