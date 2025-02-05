package com.zoho.crm.api.inventorytemplates;

import com.zoho.crm.api.sendmail.Template;
import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class InventoryTemplates implements Model, Template
{
	private OffsetDateTime createdTime;

	private OffsetDateTime modifiedTime;

	private OffsetDateTime lastUsageTime;

	private Folder folder;

	private ModuleMap module;

	private User createdBy;

	private User modifiedBy;

	private String name;

	private Long id;

	private String editorMode;

	private String category;

	private Boolean favorite;

	private String content;

	private Boolean active;

	private String mailContent;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of lastUsageTime
	 * @return An instance of OffsetDateTime
	 */
	public OffsetDateTime getLastUsageTime()
	{
		return  this.lastUsageTime;

	}

	/**
	 * The method to set the value to lastUsageTime
	 * @param lastUsageTime An instance of OffsetDateTime
	 */
	public void setLastUsageTime(OffsetDateTime lastUsageTime)
	{
		 this.lastUsageTime = lastUsageTime;

		 this.keyModified.put("last_usage_time", 1);

	}

	/**
	 * The method to get the value of folder
	 * @return An instance of Folder
	 */
	public Folder getFolder()
	{
		return  this.folder;

	}

	/**
	 * The method to set the value to folder
	 * @param folder An instance of Folder
	 */
	public void setFolder(Folder folder)
	{
		 this.folder = folder;

		 this.keyModified.put("folder", 1);

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
	 * The method to get the value of createdBy
	 * @return An instance of User
	 */
	public User getCreatedBy()
	{
		return  this.createdBy;

	}

	/**
	 * The method to set the value to createdBy
	 * @param createdBy An instance of User
	 */
	public void setCreatedBy(User createdBy)
	{
		 this.createdBy = createdBy;

		 this.keyModified.put("created_by", 1);

	}

	/**
	 * The method to get the value of modifiedBy
	 * @return An instance of User
	 */
	public User getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of User
	 */
	public void setModifiedBy(User modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

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
	 * The method to get the value of editorMode
	 * @return A String representing the editorMode
	 */
	public String getEditorMode()
	{
		return  this.editorMode;

	}

	/**
	 * The method to set the value to editorMode
	 * @param editorMode A String representing the editorMode
	 */
	public void setEditorMode(String editorMode)
	{
		 this.editorMode = editorMode;

		 this.keyModified.put("editor_mode", 1);

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
	 * The method to get the value of favorite
	 * @return A Boolean representing the favorite
	 */
	public Boolean getFavorite()
	{
		return  this.favorite;

	}

	/**
	 * The method to set the value to favorite
	 * @param favorite A Boolean representing the favorite
	 */
	public void setFavorite(Boolean favorite)
	{
		 this.favorite = favorite;

		 this.keyModified.put("favorite", 1);

	}

	/**
	 * The method to get the value of content
	 * @return A String representing the content
	 */
	public String getContent()
	{
		return  this.content;

	}

	/**
	 * The method to set the value to content
	 * @param content A String representing the content
	 */
	public void setContent(String content)
	{
		 this.content = content;

		 this.keyModified.put("content", 1);

	}

	/**
	 * The method to get the value of active
	 * @return A Boolean representing the active
	 */
	public Boolean getActive()
	{
		return  this.active;

	}

	/**
	 * The method to set the value to active
	 * @param active A Boolean representing the active
	 */
	public void setActive(Boolean active)
	{
		 this.active = active;

		 this.keyModified.put("active", 1);

	}

	/**
	 * The method to get the value of mailContent
	 * @return A String representing the mailContent
	 */
	public String getMailContent()
	{
		return  this.mailContent;

	}

	/**
	 * The method to set the value to mailContent
	 * @param mailContent A String representing the mailContent
	 */
	public void setMailContent(String mailContent)
	{
		 this.mailContent = mailContent;

		 this.keyModified.put("mail_content", 1);

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