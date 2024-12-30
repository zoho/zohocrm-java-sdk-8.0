package com.zoho.crm.api.templates;

import com.zoho.crm.api.util.Model;
import java.time.OffsetDateTime;
import java.util.HashMap;

public class Templates implements Model
{
	private Folder folder;

	private Folder modifiedBy;

	private String module;

	private OffsetDateTime modifiedTime;

	private String subject;

	private String name;

	private Boolean consentLinked;

	private Boolean favourite;

	private Boolean attachmentPresent;

	private Long id;

	private HashMap<String, Integer> keyModified = new HashMap<String, Integer>();


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
	 * The method to get the value of modifiedBy
	 * @return An instance of Folder
	 */
	public Folder getModifiedBy()
	{
		return  this.modifiedBy;

	}

	/**
	 * The method to set the value to modifiedBy
	 * @param modifiedBy An instance of Folder
	 */
	public void setModifiedBy(Folder modifiedBy)
	{
		 this.modifiedBy = modifiedBy;

		 this.keyModified.put("modified_by", 1);

	}

	/**
	 * The method to get the value of module
	 * @return A String representing the module
	 */
	public String getModule()
	{
		return  this.module;

	}

	/**
	 * The method to set the value to module
	 * @param module A String representing the module
	 */
	public void setModule(String module)
	{
		 this.module = module;

		 this.keyModified.put("module", 1);

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
	 * The method to get the value of subject
	 * @return A String representing the subject
	 */
	public String getSubject()
	{
		return  this.subject;

	}

	/**
	 * The method to set the value to subject
	 * @param subject A String representing the subject
	 */
	public void setSubject(String subject)
	{
		 this.subject = subject;

		 this.keyModified.put("subject", 1);

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
	 * The method to get the value of consentLinked
	 * @return A Boolean representing the consentLinked
	 */
	public Boolean getConsentLinked()
	{
		return  this.consentLinked;

	}

	/**
	 * The method to set the value to consentLinked
	 * @param consentLinked A Boolean representing the consentLinked
	 */
	public void setConsentLinked(Boolean consentLinked)
	{
		 this.consentLinked = consentLinked;

		 this.keyModified.put("consent_linked", 1);

	}

	/**
	 * The method to get the value of favourite
	 * @return A Boolean representing the favourite
	 */
	public Boolean getFavourite()
	{
		return  this.favourite;

	}

	/**
	 * The method to set the value to favourite
	 * @param favourite A Boolean representing the favourite
	 */
	public void setFavourite(Boolean favourite)
	{
		 this.favourite = favourite;

		 this.keyModified.put("favourite", 1);

	}

	/**
	 * The method to get the value of attachmentPresent
	 * @return A Boolean representing the attachmentPresent
	 */
	public Boolean getAttachmentPresent()
	{
		return  this.attachmentPresent;

	}

	/**
	 * The method to set the value to attachmentPresent
	 * @param attachmentPresent A Boolean representing the attachmentPresent
	 */
	public void setAttachmentPresent(Boolean attachmentPresent)
	{
		 this.attachmentPresent = attachmentPresent;

		 this.keyModified.put("attachment_present", 1);

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