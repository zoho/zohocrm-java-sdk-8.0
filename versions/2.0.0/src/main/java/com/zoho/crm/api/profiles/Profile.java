package com.zoho.crm.api.profiles;

import com.zoho.crm.api.users.MinifiedUser;
import com.zoho.crm.api.util.Choice;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

public class Profile implements Model
{
	private DefaultView defaultView;

	private String name;

	private String description;

	private Long id;

	private Boolean default1;

	private Boolean delete;

	private String permissionType;

	private Boolean custom;

	private String displayLabel;

	private Choice<String> type;

	private List<PermissionDetail> permissionsDetails;

	private List<Section> sections;

	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private MinifiedUser modifiedBy;

	private Boolean category;

	private MinifiedUser createdBy;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


	/**
	 * The method to get the value of defaultView
	 * @return An instance of DefaultView
	 */
	public DefaultView getDefaultView()
	{
		return  this.defaultView;

	}

	/**
	 * The method to set the value to defaultView
	 * @param defaultView An instance of DefaultView
	 */
	public void setDefaultView(DefaultView defaultView)
	{
		 this.defaultView = defaultView;

		 this.keyModified.put("_default_view", 1);

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
	 * The method to get the value of permissionType
	 * @return A String representing the permissionType
	 */
	public String getPermissionType()
	{
		return  this.permissionType;

	}

	/**
	 * The method to set the value to permissionType
	 * @param permissionType A String representing the permissionType
	 */
	public void setPermissionType(String permissionType)
	{
		 this.permissionType = permissionType;

		 this.keyModified.put("permission_type", 1);

	}

	/**
	 * The method to get the value of custom
	 * @return A Boolean representing the custom
	 */
	public Boolean getCustom()
	{
		return  this.custom;

	}

	/**
	 * The method to set the value to custom
	 * @param custom A Boolean representing the custom
	 */
	public void setCustom(Boolean custom)
	{
		 this.custom = custom;

		 this.keyModified.put("custom", 1);

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
	 * The method to get the value of permissionsDetails
	 * @return An instance of List<PermissionDetail>
	 */
	public List<PermissionDetail> getPermissionsDetails()
	{
		return  this.permissionsDetails;

	}

	/**
	 * The method to set the value to permissionsDetails
	 * @param permissionsDetails An instance of List<PermissionDetail>
	 */
	public void setPermissionsDetails(List<PermissionDetail> permissionsDetails)
	{
		 this.permissionsDetails = permissionsDetails;

		 this.keyModified.put("permissions_details", 1);

	}

	/**
	 * The method to get the value of sections
	 * @return An instance of List<Section>
	 */
	public List<Section> getSections()
	{
		return  this.sections;

	}

	/**
	 * The method to set the value to sections
	 * @param sections An instance of List<Section>
	 */
	public void setSections(List<Section> sections)
	{
		 this.sections = sections;

		 this.keyModified.put("sections", 1);

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
	 * The method to get the value of category
	 * @return A Boolean representing the category
	 */
	public Boolean getCategory()
	{
		return  this.category;

	}

	/**
	 * The method to set the value to category
	 * @param category A Boolean representing the category
	 */
	public void setCategory(Boolean category)
	{
		 this.category = category;

		 this.keyModified.put("category", 1);

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